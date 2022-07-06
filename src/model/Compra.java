package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class Compra extends BaseModel<Long>{
    private LocalDate dataCompra;
    private LocalTime horaCompra;
    private BigDecimal valorTotal;
    private List<Produto> produtos;
}
