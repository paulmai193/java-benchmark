package logia.research.java.art.service;

import logia.research.java.art.entity.IPackage;

public interface ILocatorService {
    IPackage getByLocation(byte rackNo, byte shelveNo);
}
