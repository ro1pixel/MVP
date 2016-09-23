package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.MyModel;
import presenter.MyPresenter;
import presenter.Presenter;
import view.MazeWindow;
import view.MyView;

public class Run {

	public static void main(String[] args) {
		
		/*/BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
				
		MyView view = new MyView(in, out);
		MyModel model = new MyModel();
		
		MyPresenter presenter = new MyPresenter(model, view);
		model.addObserver(presenter);
		view.addObserver(presenter);
				
		view.start();
		/*/
		
		MazeWindow mz=new MazeWindow(500, 500);
		mz.run();
	}

}
