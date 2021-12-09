package nnoopt.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sun.nio.ch.Net;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller implements Initializable {

    private Path clientDir;
    public TextField input;
    public ListView <String> listView;
    public ListView<String> statuses;
    private Net net;
    private byte [] buf;

    @FXML
    public void sendMsg(ActionEvent actionEvent) throws IOException {
        sendFile(input.getText());
    }
    private void addStatus(String msg){

        Platform.runLater(() -> statuses.getItems().add(msg));
    }

    private void sendFile (String fileName) throws IOException {
        Path file = clientDir.resolve(fileName);
//        net.writeUtf("#file#");
//        net.writeUtf(fileName.replaceAll(" +", "_"));
//        net.writeLong(Files.size(file));
//        try (FileInputStream fis = new FileInputStream(file.toFile())) {
//
//            int read;
//            while ((read = fis.read(buf)) !=-1){
//                net.writeBytes(buf, 0, read);
//            }
//        }
    }

    private void initClickListener(){
        listView.setOnMouseClicked(e->{
            if (e.getClickCount()==2){
                String item = listView.getSelectionModel().getSelectedItem();
                input.setText(item);
            }
        });
    }

    private void fillFileView() throws IOException {
        List<String> files = Files.list(clientDir).map(p-> p.getFileName().toString()).collect(Collectors.toList());
        listView.getItems().addAll(files);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            buf = new byte[8192];
            clientDir = Paths.get("client");
            fillFileView();
            initClickListener();
            Socket socket = new Socket("localhost", 8189);
//            net = new Net(this::addStatus, socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upload(ActionEvent actionEvent) {
    }

    public void download(ActionEvent actionEvent) {
    }
}