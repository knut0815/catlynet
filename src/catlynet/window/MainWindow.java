/*
 * MainWindow.java Copyright (C) 2019. Daniel H. Huson
 *
 *  (Some files contain contributions from other authors, who are then mentioned separately.)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package catlynet.window;

import catlynet.action.ExportManager;
import catlynet.io.CRSFileFilter;
import catlynet.io.FileOpener;
import catlynet.model.ReactionSystem;
import catlynet.tab.TabManager;
import catlynet.view.ReactionGraphView;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import jloda.fx.undo.UndoManager;
import jloda.fx.util.ExtendedFXMLLoader;
import jloda.fx.util.MemoryUsage;
import jloda.fx.util.PrintStreamToTextArea;
import jloda.fx.window.IMainWindow;
import jloda.fx.window.MainWindowManager;
import jloda.util.Basic;
import jloda.util.FileOpenManager;
import jloda.util.ProgramProperties;

import java.io.PrintStream;
import java.util.Collections;

/**
 * the main window
 * Daniel Huson, 7.2019
 */
public class MainWindow implements IMainWindow {
    private Stage stage;
    private final MainWindowController controller;
    private final Parent root;
    private final FlowPane statusPane;


    private final ReactionGraphView reactionGraphView;

    private final PrintStream logStream;

    private final UndoManager undoManager = new UndoManager();

    private final ExportManager exportManager;

    private final TabManager tabManager;

    private final Document document = new Document();

    private final BooleanProperty hasFoodInput = new SimpleBooleanProperty(false);
    private BooleanProperty hasReactionsInput = new SimpleBooleanProperty(false);
    private final BooleanProperty empty = new SimpleBooleanProperty();

    /**
     * constructor
     */
    public MainWindow() {
        Platform.setImplicitExit(false);

        {
            final ExtendedFXMLLoader<MainWindowController> extendedFXMLLoader = new ExtendedFXMLLoader<>(this.getClass());
            root = extendedFXMLLoader.getRoot();
            controller = extendedFXMLLoader.getController();

            logStream = new PrintStreamToTextArea(controller.getLogTextArea());

            statusPane = controller.getStatusFlowPane();

            reactionGraphView = new ReactionGraphView(getInputReactionSystem(), controller, getLogStream());
        }

        exportManager = new ExportManager(this);

        tabManager = new TabManager(controller.getOutputTabPane().getTabs());

        FileOpenManager.setExtensions(Collections.singletonList(CRSFileFilter.getInstance()));
        FileOpenManager.setFileOpener(new FileOpener());
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public IMainWindow createNew() {
        return new MainWindow();
    }

    @Override
    public void show(Stage stage, double screenX, double screenY, double width, double height) {
        if (stage == null)
            stage = new Stage();
        this.stage = stage;
        stage.getIcons().addAll(ProgramProperties.getProgramIconsFX());

        final Scene scene = new Scene(root, width, height);

        stage.setScene(scene);
        stage.sizeToScene();
        stage.setX(screenX);
        stage.setY(screenY);

        final InvalidationListener listener = ((e) -> {
            if (document.getFileName() == null)
                getStage().setTitle("Untitled - " + ProgramProperties.getProgramName());
            else
                getStage().setTitle(Basic.getFileNameWithoutPath(document.getFileName()) + (document.isDirty() ? "*" : "") + " - " + ProgramProperties.getProgramName());
        });
        document.fileNameProperty().addListener(listener);

        document.dirtyProperty().addListener(listener);

        getStage().titleProperty().addListener((e) -> MainWindowManager.getInstance().fireChanged());

        ControlBindings.setup(this);

        final MemoryUsage memoryUsage = MemoryUsage.getInstance();
        controller.getMemoryUsageLabel().textProperty().bind(memoryUsage.memoryUsageStringProperty());

        stage.show();

        controller.getInputFoodTextArea().textProperty().length().addListener((c, o, n) -> hasFoodInput.set(n.intValue() > 0));

        controller.getInputTextArea().textProperty().length().addListener((c, o, n) -> hasReactionsInput.set(n.intValue() > 0));
        empty.bind(controller.getInputFoodTextArea().textProperty().isEmpty().and(controller.getInputTextArea().textProperty().isEmpty()));
    }

    @Override
    public boolean isEmpty() {
        return empty.get();
    }

    @Override
    public void close() {
        stage.hide();
    }

    public UndoManager getUndoManager() {
        return undoManager;
    }

    public MainWindowController getController() {
        return controller;
    }

    public FlowPane getStatusPane() {
        return statusPane;
    }

    public Document getDocument() {
        return document;
    }

    public ReactionSystem getInputReactionSystem() {
        return document.getInputReactionSystem();
    }

    public ReactionSystem getReactionSystem(String name) {
        return document.getReactionSystem(name);
    }


    public PrintStream getLogStream() {
        return logStream;
    }

    public ReactionGraphView getReactionGraphView() {
        return reactionGraphView;
    }

    public ExportManager getExportManager() {
        return exportManager;
    }

    public TabManager getTabManager() {
        return tabManager;
    }
}
