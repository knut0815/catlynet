package catlynet.window;

import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jloda.fx.control.SplittableTabPane;
import jloda.fx.window.IMainWindow;
import jloda.fx.window.MainWindowManager;
import jloda.util.ProgramProperties;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem saveMenItem;

    @FXML
    private Menu recentFilesMenu;

    @FXML
    private MenuItem pageSetupMenuItem;

    @FXML
    private MenuItem printMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem quitMenuItem;

    @FXML
    private Menu editMenu;

    @FXML
    private MenuItem undoMenuItem;

    @FXML
    private MenuItem redoMenuItem;

    @FXML
    private MenuItem cutMenuItem;

    @FXML
    private MenuItem copyMenuItem;

    @FXML
    private MenuItem pasteMenuItem;

    @FXML
    private MenuItem clearMenuItem;

    @FXML
    private MenuItem selectAllMenuItem;

    @FXML
    private MenuItem selectNoneMenuItem;

    @FXML
    private MenuItem findMenuItem;

    @FXML
    private MenuItem findAgainMenuItem;


    @FXML
    private Menu algorithmMenu;

    @FXML
    private MenuItem verifyInputMenuItem;

    @FXML
    private MenuItem runRAFMenuItem;

    @FXML
    private MenuItem runCAFMenuItem;

    @FXML
    private MenuItem runPseudoRAFMenuItem;

    @FXML
    private MenuItem runMenuItem;

    @FXML
    private Menu windowMenu;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Button runButton;

    @FXML
    private FlowPane statusFlowPane;

    @FXML
    private Label memoryUsageLabel;

    @FXML
    private StackPane outputPane;

    @FXML
    private ComboBox<?> foodSetComboBox;

    @FXML
    private TextArea inputTextArea;

    @FXML
    private TabPane outputTabPane;

    private SplittableTabPane outputSplittableTabPane;

    @FXML
    private SplitPane mainSplitPane;

    @FXML
    private TextArea logTextArea;

    @FXML
    private Tab rafTab;

    @FXML
    private TextArea rafTextArea;

    @FXML
    private Tab cafTab;

    @FXML
    private TextArea cafTextArea;

    @FXML
    private Tab pseudoRafTab;

    @FXML
    private TextArea pseudoRAFTextArea;

    @FXML
    private VBox reactionsInputVBox;

    @FXML
    private Tab logTab;
    @FXML
    private VBox logVBox;

    @FXML
    private VBox cafVBox;

    @FXML
    private VBox rafVBox;

    @FXML
    private VBox pseudoRafVBox;

    @FXML
    void initialize() {
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert fileMenu != null : "fx:id=\"fileMenu\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert newMenuItem != null : "fx:id=\"newMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert openMenuItem != null : "fx:id=\"openMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert saveMenItem != null : "fx:id=\"saveMenItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert recentFilesMenu != null : "fx:id=\"recentFilesMenu\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert pageSetupMenuItem != null : "fx:id=\"pageSetupMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert printMenuItem != null : "fx:id=\"printMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert closeMenuItem != null : "fx:id=\"closeMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert quitMenuItem != null : "fx:id=\"quitMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert editMenu != null : "fx:id=\"editMenu\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert undoMenuItem != null : "fx:id=\"undoMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert redoMenuItem != null : "fx:id=\"redoMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert cutMenuItem != null : "fx:id=\"cutMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert copyMenuItem != null : "fx:id=\"copyMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert pasteMenuItem != null : "fx:id=\"pasteMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert clearMenuItem != null : "fx:id=\"clearMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert selectAllMenuItem != null : "fx:id=\"selectAllMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert selectNoneMenuItem != null : "fx:id=\"selectNoneMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert algorithmMenu != null : "fx:id=\"algorithmMenu\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert runMenuItem != null : "fx:id=\"analyzeMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert windowMenu != null : "fx:id=\"helpMenu\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert aboutMenuItem != null : "fx:id=\"aboutMenuItem\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert runButton != null : "fx:id=\"analyzeButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert statusFlowPane != null : "fx:id=\"statusFlowPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert memoryUsageLabel != null : "fx:id=\"memoryUsageLabel\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert outputPane != null : "fx:id=\"outputBorderPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert foodSetComboBox != null : "fx:id=\"foodSourcesComboBox\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert inputTextArea != null : "fx:id=\"crsTextArea\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert outputTabPane != null : "fx:id=\"outputTabPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert logTextArea != null : "fx:id=\"propertiesTextArea\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert rafTextArea != null : "fx:id=\"rafTextArea\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert cafTextArea != null : "fx:id=\"cafTextArea\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert pseudoRAFTextArea != null : "fx:id=\"pseudoRAFTextArea\" was not injected: check your FXML file 'MainWindow.fxml'.";


        // if we are running on MacOS, put the specific menu items in the right places
        if (ProgramProperties.isMacOS()) {
            getMenuBar().setUseSystemMenuBar(true);
            fileMenu.getItems().remove(getQuitMenuItem());
            windowMenu.getItems().remove(getAboutMenuItem());
            //editMenu.getItems().remove(getPreferencesMenuItem());
        }

        // replace tabbed pane by splittable one

        final ArrayList<Tab> tabs = new ArrayList<>(outputTabPane.getTabs());
        outputTabPane.getTabs().clear();
        outputSplittableTabPane = new SplittableTabPane();
        outputSplittableTabPane.getTabs().addAll(tabs);
        outputPane.getChildren().setAll(outputSplittableTabPane);
        if (outputSplittableTabPane.getTabs().size() > 0)
            outputSplittableTabPane.getSelectionModel().select(0);

        final InvalidationListener invalidationListener = observable -> {
            windowMenu.getItems().clear();
            if (true || !ProgramProperties.isMacOS()) {
                windowMenu.getItems().add(getAboutMenuItem());
                windowMenu.getItems().add(new SeparatorMenuItem());
            }
            int count = 0;
            for (IMainWindow mainWindow : MainWindowManager.getInstance().getMainWindows()) {
                if (mainWindow.getStage() != null) {
                    final String title = mainWindow.getStage().getTitle();
                    if (title != null) {
                        final MenuItem menuItem = new MenuItem(title.replaceAll("- " + ProgramProperties.getProgramName(), ""));
                        menuItem.setOnAction((e) -> mainWindow.getStage().toFront());
                        menuItem.setAccelerator(new KeyCharacterCombination("" + (++count), KeyCombination.SHORTCUT_DOWN));
                        windowMenu.getItems().add(menuItem);
                    }
                }
                if (MainWindowManager.getInstance().getAuxiliaryWindows(mainWindow) != null) {
                    for (Stage auxStage : MainWindowManager.getInstance().getAuxiliaryWindows(mainWindow)) {
                        final String title = auxStage.getTitle();
                        if (title != null) {
                            final MenuItem menuItem = new MenuItem(title.replaceAll("- " + ProgramProperties.getProgramName(), ""));
                            menuItem.setOnAction((e) -> auxStage.toFront());
                            windowMenu.getItems().add(menuItem);
                        }
                    }
                }
            }
        };
        MainWindowManager.getInstance().changedProperty().addListener(invalidationListener);
        invalidationListener.invalidated(null);
    }

    public ResourceBundle getResources() {
        return resources;
    }

    public URL getLocation() {
        return location;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public Menu getFileMenu() {
        return fileMenu;
    }

    public MenuItem getNewMenuItem() {
        return newMenuItem;
    }

    public MenuItem getOpenMenuItem() {
        return openMenuItem;
    }

    public MenuItem getSaveMenItem() {
        return saveMenItem;
    }

    public Menu getRecentFilesMenu() {
        return recentFilesMenu;
    }

    public MenuItem getPageSetupMenuItem() {
        return pageSetupMenuItem;
    }

    public MenuItem getPrintMenuItem() {
        return printMenuItem;
    }

    public MenuItem getCloseMenuItem() {
        return closeMenuItem;
    }

    public MenuItem getQuitMenuItem() {
        return quitMenuItem;
    }

    public Menu getEditMenu() {
        return editMenu;
    }

    public MenuItem getUndoMenuItem() {
        return undoMenuItem;
    }

    public MenuItem getRedoMenuItem() {
        return redoMenuItem;
    }

    public MenuItem getCutMenuItem() {
        return cutMenuItem;
    }

    public MenuItem getCopyMenuItem() {
        return copyMenuItem;
    }

    public MenuItem getPasteMenuItem() {
        return pasteMenuItem;
    }

    public MenuItem getClearMenuItem() {
        return clearMenuItem;
    }

    public MenuItem getSelectAllMenuItem() {
        return selectAllMenuItem;
    }

    public MenuItem getSelectNoneMenuItem() {
        return selectNoneMenuItem;
    }

    public MenuItem getFindMenuItem() {
        return findMenuItem;
    }

    public MenuItem getFindAgainMenuItem() {
        return findAgainMenuItem;
    }

    public Menu getAlgorithmMenu() {
        return algorithmMenu;
    }

    public MenuItem getVerifyInputMenuItem() {
        return verifyInputMenuItem;
    }

    public MenuItem getRunMenuItem() {
        return runMenuItem;
    }

    public MenuItem getRunRAFMenuItem() {
        return runRAFMenuItem;
    }

    public MenuItem getRunCAFMenuItem() {
        return runCAFMenuItem;
    }

    public MenuItem getRunPseudoRAFMenuItem() {
        return runPseudoRAFMenuItem;
    }

    public Menu getWindowMenu() {
        return windowMenu;
    }

    public MenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public Button getRunButton() {
        return runButton;
    }

    public FlowPane getStatusFlowPane() {
        return statusFlowPane;
    }

    public Label getMemoryUsageLabel() {
        return memoryUsageLabel;
    }

    public Pane getOutputPane() {
        return outputPane;
    }

    public TextArea getInputTextArea() {
        return inputTextArea;
    }

    public SplittableTabPane getOutputSplittableTabPane() {
        return outputSplittableTabPane;
    }

    public TextArea getLogTextArea() {
        return logTextArea;
    }

    public TextArea getRafTextArea() {
        return rafTextArea;
    }

    public TextArea getCafTextArea() {
        return cafTextArea;
    }

    public TextArea getPseudoRAFTextArea() {
        return pseudoRAFTextArea;
    }

    public Tab getRafTab() {
        return rafTab;
    }

    public Tab getCafTab() {
        return cafTab;
    }

    public Tab getPseudoRafTab() {
        return pseudoRafTab;
    }

    public ComboBox<String> getFoodSetComboBox() {
        return (ComboBox<String>) foodSetComboBox;
    }

    public VBox getReactionsInputVBox() {
        return reactionsInputVBox;
    }

    public SplitPane getMainSplitPane() {
        return mainSplitPane;
    }

    public VBox getLogVBox() {
        return logVBox;
    }

    public VBox getCafVBox() {
        return cafVBox;
    }

    public VBox getRafVBox() {
        return rafVBox;
    }

    public VBox getPseudoRafVBox() {
        return pseudoRafVBox;
    }

    public Tab getLogTab() {
        return logTab;
    }
}