package cse.maven.sample;

import cse.maven.sample.exception.InvalidNicPropException;

public class NicProp {
	private final String nic;
        private final int nic_Int;
		
	public NicProp(String nic) throws InvalidNicPropException {
		super();
		this.nic= nic;
                try{
                    this.nic_Int=Integer.parseInt(nic.substring(0, 9));
                }catch(Exception e){
                    throw new InvalidNicPropException(); 
                }
	}

	public String getNicString() {
		return this.nic;
	}

	public int getNicInt() {
		return Integer.getInteger(nic);
	}
}
