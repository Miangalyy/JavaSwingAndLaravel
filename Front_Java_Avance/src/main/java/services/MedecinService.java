/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Model.Medecin;
import Response.ListMedocResponse;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author pc
 */
public class MedecinService {

    private static String baseURI = "http://127.0.0.1:8000/api/medecin";

    public static List<Medecin> Affiche() {
        try {
            WebTarget target = getWebTarget();
            ListMedocResponse response = target.request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get(ListMedocResponse.class);

            return response.getData();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void AddMedoc(Medecin medoc) {
        try {
            WebTarget target = getWebTarget();

            Response response = target.request()
                    .post(Entity.entity(medoc, MediaType.APPLICATION_JSON), Response.class);

            System.out.println("Status: " + response.getStatus());
            System.out.println("Response body: " + response.readEntity(String.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void UpdateMedoc(String medocId, Medecin medoc) {

        try {
            WebTarget target = getWebTarget();
            Response response = target.path(medocId)
                    .request()
                    .put(
                            Entity.entity(medoc, MediaType.APPLICATION_JSON),
                            Response.class);

            System.out.println("Status: " + response.getStatus());
            System.out.println("Response body: " + response.readEntity(String.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testDelete(String medocId) {
        try {
            WebTarget target = getWebTarget();

            Response response = target.path(medocId)
                    .request()
                    .delete(Response.class);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static WebTarget getWebTarget() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        return client.target(baseURI);
    }
}
