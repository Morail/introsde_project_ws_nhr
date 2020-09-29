package it.unitn.introsde.nhr.dao;

import it.unitn.introsde.nhr.patientws.querypatient.Patient;

import java.util.HashMap;
import java.util.Map;

public enum PatientDao {
    instance;

    private Map<Long, Patient> contentProvider = new HashMap<Long, Patient>();

    private PatientDao() {
    }

    public Map<Long, Patient> getDataProvider() {

        return contentProvider;

    }
}