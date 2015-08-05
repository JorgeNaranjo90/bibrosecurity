/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author taxque
 */
@Entity
@Table(name = "purchaseOrderLine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderLine.findAll", query = "SELECT p FROM PurchaseOrderLine p"),
    @NamedQuery(name = "PurchaseOrderLine.findById", query = "SELECT p FROM PurchaseOrderLine p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseOrderLine.findByQty", query = "SELECT p FROM PurchaseOrderLine p WHERE p.qty = :qty"),
    @NamedQuery(name = "PurchaseOrderLine.findByUnitPrice", query = "SELECT p FROM PurchaseOrderLine p WHERE p.unitPrice = :unitPrice"),
    @NamedQuery(name = "PurchaseOrderLine.findBySubtotal", query = "SELECT p FROM PurchaseOrderLine p WHERE p.subtotal = :subtotal"),
    @NamedQuery(name = "PurchaseOrderLine.findByProductId", query = "SELECT p FROM PurchaseOrderLine p WHERE p.productId = :productId"),
    @NamedQuery(name = "PurchaseOrderLine.findByPurchaseOrderid", query = "SELECT p FROM PurchaseOrderLine p WHERE p.purchaseOrderid = :purchaseOrderid")})
public class PurchaseOrderLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "subtotal")
    private Double subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchaseOrder_id")
    private int purchaseOrderid;

    public PurchaseOrderLine() {
    }

    public PurchaseOrderLine(Integer id) {
        this.id = id;
    }

    public PurchaseOrderLine(Integer id, int productId, int purchaseOrderid) {
        this.id = id;
        this.productId = productId;
        this.purchaseOrderid = purchaseOrderid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPurchaseOrderid() {
        return purchaseOrderid;
    }

    public void setPurchaseOrderid(int purchaseOrderid) {
        this.purchaseOrderid = purchaseOrderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderLine)) {
            return false;
        }
        PurchaseOrderLine other = (PurchaseOrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.PurchaseOrderLine[ id=" + id + " ]";
    }
    
}
