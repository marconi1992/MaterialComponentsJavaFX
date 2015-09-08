package materialcomponents.widgets;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import materialcomponents.SVGFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;


/**
 * Created by Felipe on 06/09/2015.
 */
public class EditText extends StackPane {

    private Label hint;
    final private Scale hintScale;
    final private Line bar;
    @FXML
    private SVGPath icon;
    private TextInputControl input;

    static final int INPUT_INDEX = 0;
    static final int HINT_INDEX = 1;
    static final int ICON_INDEX = 2;

    static final String HINT_CLASS = "hint";


    public EditText() {
        getStyleClass().add("edit-text");
        input = new TextField();
        hintScale = new Scale(1, 1, 0, 0);


        bar = new Line(0, 0, 0, 0);
        bar.getStyleClass().add("bar");
        bar.setStrokeWidth(2);
        bar.setVisible(false);

        focusAnimation(input);
        setPrefWidth(200);
        setMinWidth(USE_PREF_SIZE);

        input.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (input.isFocused() || input.getText().length() > 0) {
                    bar.setEndX(newValue.doubleValue() - 2);

                }
            }
        });


        StackPane.setAlignment(bar, Pos.BOTTOM_CENTER);
        getChildren().addAll(input, bar);
    }

    private void focusAnimation(TextInputControl inputControl) {
        inputControl.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    labelAnimation(true);
                    bar.setVisible(true);
                    getStyleClass().add("focus");

                } else {
                    Iterator<String> iterator = getStyleClass().iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().equals("focus")) {
                            iterator.remove();
                        }

                    }

                    labelAnimation(false);


                }
            }
        });
    }

    private void labelAnimation(boolean sense) {
        KeyFrame frame;
        if (hint != null && input.getText().length() <= 0) {
            if (sense) {
                if (hint.getStyleClass().size() == 1) {
                    hint.getStyleClass().add(1, "up");
                }

            } else {
                hint.getStyleClass().remove(1);
            }
            frame = new KeyFrame(new Duration(200),
                    new KeyValue(hint.translateYProperty(), sense ? -20 : 0),
                    new KeyValue(hintScale.xProperty(), sense ? 0.75 : 1),
                    new KeyValue(hintScale.yProperty(), sense ? 0.75 : 1),
                    new KeyValue(bar.endXProperty(), sense ? input.getWidth() - 2 : 0));
        } else {
            frame = new KeyFrame(new Duration(200),
                    new KeyValue(bar.endXProperty(), sense ? input.getWidth() - 2 : 0));
        }
        Timeline animator = new Timeline(frame);
        animator.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!sense) {
                    bar.setVisible(false);
                }
            }
        });
        animator.play();

    }

    public final void setText(String text) {
        if (text.length() > 0) {
            labelAnimation(true);
        } else {
            labelAnimation(false);
        }
        input.setText(text);
    }

    public final String getText() {
        return input.getText();
    }

    public final void setHint(String hint) {
        if (input.getPromptText().length() == 0) {
            if (this.hint == null) {
                this.hint = new Label(hint);
                this.hint.setMouseTransparent(true);
                this.hint.getTransforms().add(hintScale);
                StackPane.setAlignment(this.hint, Pos.TOP_LEFT);
                getChildren().add(HINT_INDEX, this.hint);
                getStyleClass().add(1, HINT_CLASS);
            } else {
                this.hint.setText(hint);
            }
        }

    }

    public final String getHint() {
        if (hint != null) {
            return hint.getText();
        }
        return "";
    }

    public final void setPrompText(String prompText) {
        if (hint == null) {
            input.setPromptText(prompText);
            if (getStyleClass().size() > 1) {
                getStyleClass().remove(1);
            }

            if (getChildren().get(HINT_INDEX) instanceof Label) {
                getChildren().remove(HINT_INDEX);
            }

        }
    }

    public final String getPrompText() {
        return input.getPromptText();
    }

    public final void setTextArea(boolean isTextArea) {
        if (isTextArea) {
            input = new TextArea(input.getText());
            input.setPrefHeight(52);
            replaceInput();
        } else {
            input = new TextField();
            replaceInput();
        }
    }

    public final boolean getTextArea() {
        return input instanceof TextArea;
    }

    public final void setPasswordField(boolean isPasswordField) {
        if (isPasswordField) {
            input = new PasswordField();
            replaceInput();
        } else {
            input = new TextField();
            replaceInput();
        }
    }

    public final boolean getPasswordField() {
        return input instanceof PasswordField;
    }


    private final void replaceInput() {
        focusAnimation(input);
        getChildren().remove(INPUT_INDEX);
        getChildren().add(INPUT_INDEX, input);
    }

    public void setIcon(String path) {

        try {
            URL url = new URL(path);
            File file = new File(url.getFile());
            icon = SVGFactory.createSVG(file);
            getChildren().add(ICON_INDEX, icon);
            StackPane.setAlignment(icon, Pos.CENTER_LEFT);
            icon.setTranslateY(-4);
            icon.setTranslateX(-40);
            icon.setScaleX(1.2);
            icon.setScaleY(1.2);
            getStyleClass().add("icon");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public String getIcon() {
        return icon.getContent();
    }
}
