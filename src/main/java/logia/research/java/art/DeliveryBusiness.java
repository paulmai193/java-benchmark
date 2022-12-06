package logia.research.java.art;

import logia.research.java.art.entity.Motorbike;
import logia.research.java.art.entity.IPackage;
import logia.research.java.art.entity.Truck;
import logia.research.java.art.entity.IVehicle;
import logia.research.java.art.service.ILocatorService;

public class DeliveryBusiness {
    // Get a item or package in storage by given location (rack & shelve)
    // Then deliver to a known customer by

    // If weight > 50kg, use truck
    // Or, use motorbike

    private ILocatorService locatorService;

    public void runBusiness() {
        byte rackNo = 69, shelveNo = 8;

        IPackage aPackage = locatorService.getByLocation(rackNo, shelveNo);
        IVehicle vehicle = this.pickVehicle(aPackage);
        vehicle.deliver(aPackage);

    }

    private IVehicle pickVehicle(IPackage aPackage) {
        if (aPackage.getWeight() > 50) {
            return new Truck();
        }
        return new Motorbike();
    }
}
