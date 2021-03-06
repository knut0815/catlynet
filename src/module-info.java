module catlynet {
    requires transitive jloda;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires fx.platform.utils;
    requires com.install4j.runtime;

    exports catlynet.algorithm;
    exports catlynet.main;
    exports catlynet.tab;
    exports catlynet.window;
    exports catlynet.model;
    exports catlynet.view;
    exports catlynet.action;

    opens catlynet.tab;
    opens catlynet.window;
    opens catlynet.format;
    opens catlynet.dialog.exportlist;

    opens catlynet.resources.images;
    opens catlynet.resources.icons;
}