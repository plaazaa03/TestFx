package es.ieslosmontecillos.testfx;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
* Al extender de Application me permite poder ejecutar el comando mvn clean javafx:run
* Al ejecutarlo se me ejecuta el programa.
* */


//@ExtendWith(ApplicationExtension.class)
public class ClickableButtonTest_JUnit5AssertJ extends Application {

    private Button button;

    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     *
     * @param stage - Will be injected by the test runner.
     */
    @Start
    public void start(Stage stage) {
        button = new Button("click me!");
        button.setId("myButton");
        button.setOnAction(actionEvent -> button.setText("clicked!"));
        stage.setScene(new Scene(new StackPane(button), 100, 100));
        stage.show();
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void should_contain_button_with_text(FxRobot robot) {
        Assertions.assertThat(button).hasText("click me!");
        // or (lookup by css id):
        Assertions.assertThat(robot.lookup("#myButton").queryAs(Button.class)).hasText("click me!");
        // or (lookup by css class):
        Assertions.assertThat(robot.lookup(".button").queryAs(Button.class)).hasText("click me!");
        // or (query specific type):
        Assertions.assertThat(robot.lookup(".button").queryButton()).hasText("click me!");
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void when_button_is_clicked_text_changes(FxRobot robot) {
        // when:
        robot.clickOn(".button");

        // then:
        Assertions.assertThat(button).hasText("clicked!");
        // or (lookup by css id):
        Assertions.assertThat(robot.lookup("#myButton").queryAs(Button.class)).hasText("clicked!");
        // or (lookup by css class):
        Assertions.assertThat(robot.lookup(".button").queryAs(Button.class)).hasText("clicked!");
        // or (query specific type)
        Assertions.assertThat(robot.lookup(".button").queryButton()).hasText("clicked!");
    }
}