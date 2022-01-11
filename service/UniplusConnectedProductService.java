package sophos.uniplus.woocommerce.conection.service;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import org.junit.Assert;
import org.springframework.stereotype.Service;
import sophos.uniplus.woocommerce.conection.VO.MetaDataVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UniplusConnectedProductService {
    public void createProduct() throws SQLException {
        // Setup client
        OAuthConfig config = new OAuthConfig("https://originallinkhere.com.br",
                "ck_*******************************", //insert your ck
                "cs_*******************************"); //inset your cs

        WooCommerce wooCommerce;
        wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);

        // CREATING A PRODUCT
        Connection conexao = null;
        ResultSet rsClient = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:****/unico-Ant",
                    "postgres", "postgres1234");
            rsClient = conexao.createStatement().executeQuery("SELECT * FROM PRODUTO WHERE id = 64");
            while (rsClient.next()) {
                System.out.println("Preço 2: " + rsClient.getString("precopauta2"));
                String priceData = rsClient.getString("precopauta2");

                Map<String, Object> productInfo = new HashMap<>();
                Map<String, Object> metaProductInfo = new HashMap<>();
                productInfo.put("name", "XIAOMI REDMI 8");
                productInfo.put("type", "simple");
                productInfo.put("regular_price", priceData);
                productInfo.put("description", "Pellentesque habitant morbi tristique senectus et netus");
                var metaDataProduct = MetaDataVO.builder()
                        .key("_price_types_1")
                        .value("2500,00")
                        .build();
                productInfo.put("meta_data", List.of(metaDataProduct));
                Map product = wooCommerce.create(EndpointBaseType.PRODUCTS.getValue(), productInfo);
                Assert.assertNotNull(product);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não encontrado");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }

    public void updateProductWoocommerce() throws SQLException {

        // Setup client
            // Setup client
        OAuthConfig config = new OAuthConfig("https://originallinkhere.com.br",
                "ck_*******************************", //insert your ck
                "cs_*******************************"); //inset your cs
        WooCommerce wooCommerce;
        wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);


        // UPDATE A PRODUCT
        Connection conexaoUpdate = null;
        ResultSet rsClient = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexaoUpdate = DriverManager.getConnection("jdbc:postgresql://localhost:****/unico-Ant",
                    "postgres", "postgres1234");
            rsClient = conexaoUpdate.createStatement().executeQuery("SELECT * FROM PRODUTO WHERE id = 59");
            while (rsClient.next()) {
                String priceData = rsClient.getString("precopauta2");

                Map<String, Object> productInfoUpdate = new HashMap<>();
                productInfoUpdate.put("name", "XIAOMI REDMI 8");
                productInfoUpdate.put("type", "simple");
                productInfoUpdate.put("regular_price", priceData);
                productInfoUpdate.put("description", "Pellentesque habitant morbi tristique senectus et netus");
                var metaDataProduct = MetaDataVO.builder()
                        .key("_price_types_1")
                        .value("1521,00")
                        .build();
                productInfoUpdate.put("meta_data", List.of(metaDataProduct));
                Map product = wooCommerce.update(EndpointBaseType.PRODUCTS.getValue(), 3382, productInfoUpdate);
                Assert.assertNotNull(product);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não encontrado");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            if (conexaoUpdate != null) {
                conexaoUpdate.close();
            }
        }
    }

    public void deleteProduct() throws SQLException {
      
          // Setup client
        OAuthConfig config = new OAuthConfig("https://originallinkhere.com.br",
                "ck_*******************************", //insert your ck
                "cs_*******************************"); //inset your cs

        WooCommerce wooCommerce;
        wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);

        // DELETE PRODUCT
        Connection conexao = null;
        ResultSet rsClient = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:****/unico-Ant",
                    "postgres", "postgres1234");
            rsClient = conexao.createStatement().executeQuery("DELETE FROM PRODUTO WHERE id = 168");
            while (rsClient.next()) {
                Map product = wooCommerce.delete(EndpointBaseType.PRODUCTS.getValue(), 3382);
                Assert.assertNotNull(product);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não encontrado");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }
}



