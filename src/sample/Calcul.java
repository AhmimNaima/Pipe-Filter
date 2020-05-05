package sample;
public  class Calcul extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
    
    public Calcul(Pipe _dataINPipe, Pipe _dataOUTPipe) {
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

	public int mul(int a,int b){
    	return a*b;
	}
	public int fact(int n){
		int r;
		if (n<=1) r=1;
		else r= n*fact(n-1);
		return r;
	}
	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub
		String op=_dataINPipe.dataOUT();

		if (op=="+"){
			String nb1=_dataINPipe.dataOUT();
			String nb2=_dataINPipe.dataOUT();
		    _dataOUTPipe.dataIN(add(Integer.parseInt(nb1),Integer.parseInt(nb2))+"");
			_dataOUTPipe.dataIN(nb1);
			_dataOUTPipe.dataIN(op);
			_dataOUTPipe.dataIN(nb2);}
        else if (op=="*"){
			String nb1=_dataINPipe.dataOUT();
			String nb2=_dataINPipe.dataOUT();
        	_dataOUTPipe.dataIN(mul(Integer.parseInt(nb1),Integer.parseInt(nb2))+"");
			_dataOUTPipe.dataIN(nb1);
			_dataOUTPipe.dataIN(op);
			_dataOUTPipe.dataIN(nb2);

        }
        else{
			String nb=_dataINPipe.dataOUT();
			_dataOUTPipe.dataIN(fact(Integer.parseInt(nb))+"");
			_dataOUTPipe.dataIN(nb);
			_dataOUTPipe.dataIN(op);

		}
		}
	}

 