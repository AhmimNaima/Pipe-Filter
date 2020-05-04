
public  class FilterB extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
    
    public FilterB(Pipe _dataINPipe, Pipe _dataOUTPipe) {
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
	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}
	public int add (int a,int b){
		return a+b;
	}

	public int sub(int a,int b){
    	return a-b;
	}
	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub
		if (_dataINPipe.dataOUT()=="+"){
		    _dataOUTPipe.dataIN(add(Integer.parseInt(_dataINPipe.dataOUT()),Integer.parseInt(_dataINPipe.dataOUT()))+" ADD");}
        else{
        	_dataOUTPipe.dataIN(sub(Integer.parseInt(_dataINPipe.dataOUT()),Integer.parseInt(_dataINPipe.dataOUT()))+" SUB");
        }
		}
	}

 