package sophos.uniplus.woocommerce.conection.VO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MetaDataVO {
    private String key;
    private String value;
}
