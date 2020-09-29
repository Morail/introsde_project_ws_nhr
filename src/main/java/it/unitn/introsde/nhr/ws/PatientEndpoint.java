package it.unitn.introsde.nhr.ws;


import it.unitn.introsde.nhr.patientws.querypatient.GetPatientRequest;
import it.unitn.introsde.nhr.patientws.querypatient.GetPatientResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PatientEndpoint {

    private static final String NAMESPACE_URI = "http://www.unitn.it/introsde/nhr/patientWs/queryPatient";
    private PatientRepository patients = new PatientRepository();

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPatientRequest")
    @ResponsePayload
    public GetPatientResponse getPatient(@RequestPayload GetPatientRequest request) {
        GetPatientResponse response = new GetPatientResponse();
        response.setPatient(patients.findByTaxCode(request.getTaxCode()));

        return response;
    }
}
