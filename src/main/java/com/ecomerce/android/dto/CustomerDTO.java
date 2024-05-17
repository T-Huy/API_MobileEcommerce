package com.ecomerce.android.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String userName;

    private String address;
    private String avatar;
    private String fullname;
    private String phonenumber;
    private String province;
    private String district;
    private String subdistrict;
//    private Integer codeProvince;
//    private Integer codeDistrict;
//    private Integer codeSubDistrict;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", province=" + province +
                ", district=" + district +
                ", subdistrict=" + subdistrict +
                '}';
    }
}
