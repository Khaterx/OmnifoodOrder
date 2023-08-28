package com.omnifood.omnifoodorder.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CategoryOrder extends SharedRowData{ /* id & name => SharedRowData */

    @Column
    @CreationTimestamp
    private Date dateCreate;
    @Column
    @UpdateTimestamp
    private Date dateUpdate;
}
