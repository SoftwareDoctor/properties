/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-10-15 08:27:09
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-10-15 09:34:58
 * @FilePath: src/main/java/it/softwaredoctor/properties/model/Property.java
 * @Description: 这是默认设置, 可以在设置》工具》File Description中进行配置
 */
package it.softwaredoctor.properties.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property {
    
    private Long id;
    private String address;
    private String city;
    private String propertyType;
    private Double price;
    private String status;
    private LocalDate dateAdded;
    private LocalDate saleDate;
    private LocalDate rentalDate;
}

