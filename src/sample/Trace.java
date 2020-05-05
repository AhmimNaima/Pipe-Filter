package sample;

import sun.applet.resources.MsgAppletViewer_es;

import java.io.*;
import java.nio.file.StandardOpenOption;

public  class Trace extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
	private static InputStream in;
	private static OutputStream out;

     
    public Trace(Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}
    
    public String getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }
	public void Save(String content) {
		try {
			FileOutputStream out = new FileOutputStream("fichier.txt");
			byte[] contentInBytes = content.getBytes();
			out.write(contentInBytes);
			out.close();

		} catch (FileNotFoundException e)
		{

		} catch (IOException e)

		{
			e.printStackTrace();

		}
	}


    @Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}
	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub

          String res=getData();
		_dataOUTPipe.dataIN(res);
		 String opg=_dataINPipe.dataOUT();
		 String op=_dataINPipe.dataOUT();
		  if(op=="!"){
			  this.Save(opg + op  + "=" + res);
		  }
		  else {
			  this.Save(opg + op + _dataINPipe.dataOUT() + "=" + res);
		  }

	}
}
 