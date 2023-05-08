
package br.com.projeto_3.dto;


import java.util.Date;

public class VendaDTO {

    /**
     * @return the id_vend
     */
    public int getId_vend() {
        return id_vend;
    }

    /**
     * @param id_vend the id_vend to set
     */
    public void setId_vend(int id_vend) {
        this.id_vend = id_vend;
    }

    /**
     * @return the val_vend
     */
    public double getVal_vend() {
        return val_vend;
    }

    /**
     * @param val_vend the val_vend to set
     */
    public void setVal_vend(double val_vend) {
        this.val_vend = val_vend;
    }

    /**
     * @return the dat_vend
     */
    public Date getDat_vend() {
        return dat_vend;
    }

    /**
     * @param dat_vend the dat_vend to set
     */
    public void setDat_vend(Date dat_vend) {
        this.dat_vend = dat_vend;
    }
    private int id_vend;
    private double val_vend;
    private Date dat_vend;
    
}
