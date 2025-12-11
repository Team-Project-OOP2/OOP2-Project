package hotelmanagement.repository;

import hotelmanagement.model.Service;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {

    private static ServiceRepository instance;

    private final List<Service> services = new ArrayList<>();

    private ServiceRepository() { }

    public static ServiceRepository getInstance() {
        if (instance == null) {
            instance = new ServiceRepository();
        }
        return instance;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public List<Service> getAllServices() {
        return services;
    }

    public void deleteService(String id) {
        services.removeIf(s -> s.getId().equals(id));
    }
}
