package app.library.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper response();
    ModelMapper request();
}
