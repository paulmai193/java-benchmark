package logia.research.java.art.service;

public interface ILocatorService {
    ILocator getByLocation(byte rackNo, byte shelveNo);
}
