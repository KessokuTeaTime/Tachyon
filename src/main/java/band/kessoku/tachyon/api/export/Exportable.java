package band.kessoku.tachyon.api.export;

import java.util.Collection;

public interface Exportable<T extends Data> {

    String getType();
    Collection<T> getExportedData();

}
