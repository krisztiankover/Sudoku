package sudoku;

import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import sudoku.result.GameResultDao;
import util.guice.PersistenceModule;

import javax.inject.Inject;
import java.util.List;

@Slf4j
public class SudokuApplication extends Application{

    private GuiceContext context = new GuiceContext(this, () -> List.of(
            new AbstractModule() {
                @Override
                protected void configure() {
                    install(new PersistenceModule("sudoku"));
                    bind(GameResultDao.class);
                }
            }
    ));


    @Inject
    private FXMLLoader fxmlLoader = new FXMLLoader();

    @Override
    public void start(Stage stage) throws Exception {
        log.info("Starting application...");
        context.init();
        fxmlLoader.setLocation(getClass().getResource("/fxml/launch.fxml"));
        Parent root = fxmlLoader.load();
        //Parent root = FXMLLoader.load(SudokuApplication.class.getResource("/fxml/launch.fxml"));
        stage.setTitle("Sudoku");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
