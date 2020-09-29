package it.unitn.introsde.nhr.ws;

import it.unitn.introsde.nhr.dao.PatientDao;
import it.unitn.introsde.nhr.patientws.querypatient.Patient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class PatientRepository {

    private static final PatientDao patients = PatientDao.instance;

    @PostConstruct
    public void initData() {

        System.err.println("HERE!");

        Patient p1 = new Patient();
        p1.setUuid("a8098c1a-f86e-11da-bd1a-00112444be1e");
        p1.setTaxCode("RSSMRA70A01L378C");
        p1.setLastName("Rossi");
        p1.setFirstName("Mario");
        p1.setGender("M");
        p1.setBirthDate("1970-01-01");
        p1.setEntryDate("2020-09-28");
        p1.setExpiryDate("");

        Patient p2 = new Patient();
        p2.setUuid("a8012c1a-f86e-11da-bd1a-0da12444bex4");
        p2.setTaxCode("VRDGSP13P10H612Q");
        p2.setLastName("Verdi");
        p2.setFirstName("Giuseppe");
        p2.setGender("M");
        p2.setBirthDate("1813-10-13");
        p2.setEntryDate("2020-09-28");
        p2.setExpiryDate("");

        Patient p3 = new Patient();
        p3.setUuid("39cb0453-6979-475e-b18d-e1233eb4aa504");
        p3.setTaxCode("FRSMRC84E04Q378X");
        p3.setLastName("Frassoni");
        p3.setFirstName("Marco");
        p3.setGender("M");
        p3.setBirthDate("1984-05-04");
        p3.setEntryDate("1984-05-04");
        p3.setExpiryDate("");

        patients.getDataProvider().put(new Long(1), p1);
        patients.getDataProvider().put(new Long(2), p2);
        patients.getDataProvider().put(new Long(2), p3);

    }

    public Patient findByTaxCode(String tcode) {
        // Shall not be empty
        if (!(tcode.equals(""))) {

            // Iterate over the patient list
            for (Map.Entry<Long, Patient> p : this.patients.getDataProvider().entrySet()) {

                // Check if tcode exists
                if (tcode.equals(p.getValue().getTaxCode())) {
                    // return patient
                    return p.getValue();
                }
            }
        }

        return null;
    }

}
