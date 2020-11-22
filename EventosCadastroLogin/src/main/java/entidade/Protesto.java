
package entidade;

import java.util.Date;
import java.io.Serializable;

public class Protesto implements Serializable {

    private int id;
    private String cnpj;
    private String nome;
    private Date data;
    private double valor;

    public Protesto() {

    }

    public Protesto(String cnpj, String nome, Date data, double valor) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", cnpj=" + cnpj + ", nome=" + nome + ", data=" + data + ", valor=" + valor + '}';
    }

}

// Inserts no banco
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (1,"1650021019499","Eleifend Ltd","2018-09-30","8651.49"),(2,"1611011507099","Montes Foundation","2019-10-02","9190.25"),(3,"1637120533099","A Enim Suspendisse Consulting","2020-01-04","6896.61"),(4,"1612042264299","Tellus Non Industries","2020-08-18","6921.30"),(5,"1634051445099","Sem Limited","2020-02-29","9176.11"),(6,"1620072754099","Velit Quisque Corporation","2019-02-17","6894.06"),(7,"1611080522299","Est Arcu Inc.","2019-10-27","5315.79"),(8,"1602073094999","Posuere At Velit Associates","2018-10-29","4458.46"),(9,"1659102313499","Hendrerit Consectetuer Cursus Industries","2019-12-06","3243.34"),(10,"1692072574899","Ac Mi Foundation","2018-12-14","1418.50");
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (11,"1697062614299","Aliquet Molestie Tellus Foundation","2019-11-07","6793.38"),(12,"1645022557499","Tristique Limited","2020-03-29","1563.55"),(13,"1642012139699","Quam Corporation","2019-04-12","4128.33"),(14,"1653082034599","Mauris Corporation","2018-11-07","4379.17"),(15,"1697112658099","Dui Quis Accumsan LLC","2019-09-18","5770.57"),(16,"1600010819599","Mi Eleifend Egestas LLP","2019-01-05","2899.85"),(17,"1685082536299","Praesent Incorporated","2018-10-06","4818.94"),(18,"1643070609899","Ornare Sagittis Institute","2019-02-16","1601.83"),(19,"1612090661399","Amet Risus Donec Foundation","2019-02-13","1402.32"),(20,"1644101693699","Enim Condimentum Eget Limited","2020-06-10","9596.57");
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (21,"1642050790299","Sem Corporation","2020-09-02","9678.03"),(22,"1678120938399","Parturient Montes Inc.","2020-08-17","2885.77"),(23,"1603050944999","Felis Orci Adipiscing Inc.","2020-02-14","1305.14"),(24,"1661031376599","In Cursus Incorporated","2019-11-27","3279.07"),(25,"1673010651999","Vehicula Aliquet PC","2019-11-05","4875.28"),(26,"1627023074399","Mauris Ltd","2019-04-16","9651.97"),(27,"1656022426499","Sapien Corp.","2019-09-05","5639.88"),(28,"1604051971399","Tempor Corp.","2019-02-19","9404.92"),(29,"1684120750499","Aenean Industries","2020-01-16","2122.74"),(30,"1688060926399","Morbi Ltd","2020-06-07","5414.44");
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (31,"1626082176399","Suscipit Nonummy Consulting","2019-03-29","4020.73"),(32,"1662080267699","Nibh Ltd","2019-02-10","7801.99"),(33,"1696100752199","Tempor Augue Ac PC","2020-04-04","7188.03"),(34,"1646042142599","Eu PC","2018-11-19","6395.38"),(35,"1645112507699","Nulla Ltd","2020-01-07","6151.28"),(36,"1684080415499","Mauris Vestibulum Corporation","2020-04-05","6777.70"),(37,"1673041358499","Mattis Integer Eu Consulting","2018-11-12","9832.82"),(38,"1676020174799","Augue Id Ante Consulting","2019-09-12","4177.41"),(39,"1679011987599","Felis LLP","2019-03-10","2720.29"),(40,"1633050973499","Tellus Phasellus Institute","2019-12-19","7784.66");
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (41,"1632042784299","Magna Nam Ligula Ltd","2019-07-04","7294.19"),(42,"1655072867499","Mattis Semper Dui Incorporated","2020-08-09","3011.84"),(43,"1631072354299","Mauris Id Consulting","2019-05-06","4706.86"),(44,"1690022071299","Imperdiet Non Vestibulum Ltd","2019-03-07","7504.48"),(45,"1620101887899","Lacus Cras Interdum Company","2020-02-01","1758.16"),(46,"1618012967599","Sit PC","2018-12-27","5116.16"),(47,"1679021504299","Massa Lobortis Ultrices Institute","2019-07-05","4141.93"),(48,"1687070468699","Vulputate Associates","2020-01-05","2975.73"),(49,"1605050725599","Facilisis Industries","2019-03-05","7478.36"),(50,"1684072108799","Cras Ltd","2019-07-16","9033.87");
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (51,"1683012078299","Auctor Odio PC","2019-04-08","6552.93"),(52,"1659051561999","Quisque Industries","2020-08-10","5485.10"),(53,"1694010344999","Arcu Morbi Sit Ltd","2020-07-24","4429.18"),(54,"1650031011299","Aenean Company","2020-07-26","7172.38"),(55,"1692020250899","Curabitur Corp.","2018-11-09","6406.59"),(56,"1610080292799","Sed Corporation","2020-04-30","6575.04"),(57,"1624111194699","Blandit LLP","2018-12-08","6427.06"),(58,"1616053013199","Felis Donec Tempor Consulting","2019-06-19","9829.58"),(59,"1647110523899","Dui Industries","2019-06-22","4522.97"),(60,"1679032266999","Turpis Incorporated","2020-05-08","9425.15");
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (61,"1624112000399","Mattis PC","2019-04-02","1322.15"),(62,"1688041195199","Eu Turpis Industries","2020-02-10","2609.15"),(63,"1650112158499","Dui Corporation","2020-04-26","7606.19"),(64,"1686022868699","Lacus PC","2020-09-18","2395.06"),(65,"1626090970899","Amet Risus Donec Inc.","2020-09-09","8734.58"),(66,"1621083007499","Etiam Gravida Institute","2020-05-27","4941.97"),(67,"1620012447999","In Ltd","2019-01-11","7446.36"),(68,"1622122354599","Amet Risus Foundation","2019-10-12","8707.56"),(69,"1634120711899","Non LLP","2020-08-10","1976.59"),(70,"1672061296199","Natoque Penatibus Et Corp.","2020-01-18","5100.22");
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (71,"1650121133699","Tristique Corp.","2019-05-14","8422.81"),(72,"1655010874799","Ut Corporation","2018-12-24","9353.65"),(73,"1670082429699","Tempor Est Inc.","2020-06-16","1608.21"),(74,"1692051326699","Orci In Inc.","2018-12-27","5119.58"),(75,"1691050212699","Magna Tellus Faucibus PC","2019-09-09","3170.95"),(76,"1647042639399","Ultrices Limited","2020-03-10","7756.11"),(77,"1609031552099","Donec Porttitor LLP","2020-07-12","5318.46"),(78,"1617032644799","Magna Ut Associates","2019-05-17","9798.84"),(79,"1645120928199","Dignissim Pharetra Nam Industries","2020-07-08","2530.18"),(80,"1647060666799","Aliquam Industries","2019-03-17","4624.61");
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (81,"1613120646199","Nonummy Ultricies Foundation","2019-07-11","2618.88"),(82,"1680080263199","Gravida Sit Amet Industries","2019-11-16","1701.34"),(83,"1621012428999","Mollis Associates","2020-06-15","5067.96"),(84,"1677020286899","Vestibulum Ante Ipsum Foundation","2020-02-21","3087.23"),(85,"1687081199099","Primis Incorporated","2020-01-21","2560.30"),(86,"1667020748199","Nam Consequat Dolor LLP","2019-11-01","8033.62"),(87,"1673071039399","Donec PC","2020-01-08","1667.37"),(88,"1665041470599","Phasellus In Felis PC","2019-10-05","8552.85"),(89,"1650010659399","Arcu Foundation","2020-06-20","5865.12"),(90,"1680061912199","Sagittis Semper Nam Corporation","2019-11-10","8559.13");
//INSERT INTO protesto (id,cnpj,nome,data,valor) VALUES (91,"1629080739999","Molestie Orci Tincidunt Institute","2020-09-07","6695.47"),(92,"1644032897399","Quis Inc.","2019-12-31","2918.78"),(93,"1661071126199","Aliquam Nec Associates","2019-05-14","2109.79"),(94,"1640011518799","Velit Sed PC","2020-03-09","3966.67"),(95,"1661020531299","Libero Proin Mi Incorporated","2020-06-15","1580.64"),(96,"1687071412099","Eget Magna Ltd","2018-11-25","4815.55"),(97,"1686112586799","Ornare Lectus Consulting","2020-03-11","6906.96"),(98,"1692062523999","Blandit Enim Consequat Institute","2019-12-18","5025.42"),(99,"1645112829199","Proin Ultrices Duis Inc.","2019-03-01","5718.38"),(100,"1650041775599","Nunc Quis LLP","2019-08-22","2373.46");
