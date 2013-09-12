package cse.maven.sample;

import cse.maven.sample.exception.InvalidNicPropException;
import java.util.Date;

// given NIC no. calculate birthday, gender, etc.. or invalid nic  
/*
 * NIC Formula
*Birthyear = first two digits
* 
 */

public class NIC_interpreter {

	
	public NicProp createNicProp(String nic) throws InvalidNicPropException {
		try {
                    return new NicProp(nic);
		} catch(Exception ex) {
                    throw new InvalidNicPropException();
		}
	}
	
	public Date calculateDate(NicProp prop) throws InvalidNicPropException {
		if(!validate(prop)) {
			throw new InvalidNicPropException();
		}
                Date bday=new Date();
                bday.setYear(this.getYear(prop.getNicString()));
                
                int mo = 0, da = 0;
                int d=Integer.parseInt(prop.getNicString().substring(2, 5));
                int days =d>500?d-500:d; 
                int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                
                for (int i = 0; i < month.length; i++) {
                    if (days < month[i]){
                        mo = i + 1;
                        da = days;
                        break;
                    } else {
                        days = days - month[i];
                    }
                }   
		bday.setMonth(mo-1);
                bday.setDate(da);
                return bday;
        }
        
        private int getYear(String nic){
            return Integer.parseInt(nic.substring(0, 2));
        }
        
        public String getGender(NicProp nicProp) {
            String M = "Male", F = "Female";
            int d = Integer.parseInt(nicProp.getNicString().substring(2, 5));
            if (d > 500) {
                return F;
            } else {
                return M;
            }
        }
        
	public boolean validate(NicProp nicProp) {
            if(nicProp.getNicString().length()==10 && Character.isLetter(nicProp.getNicString().charAt(9))){
                return true;
            }else{
                return false;
            }		
	}
        
        public String isVoter(NicProp np){
            if(np.getNicString().charAt(9)=='v'){
                return "Yes";
            }else{
                return "No";
            }
        }
}
