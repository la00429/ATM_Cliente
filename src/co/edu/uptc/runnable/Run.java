package co.edu.uptc.runnable;

import co.edu.uptc.presenter.Presenter;
import co.edu.uptc.view.View;

import java.io.IOException;

public class Run {

    private View view;
    private Presenter presenter;

    public Run() {
        this.view = new View();
    }

    public void loadHost() {
        String host = new String();
        while (host==null || host.isEmpty()) {
            host = view.readData("Input ip of the server");
        }
        this.presenter = new Presenter(host);
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public static void main(String[] args) throws IOException {
        Run run = new Run();
        run.loadHost();
        run.getPresenter().start();
    }
}
