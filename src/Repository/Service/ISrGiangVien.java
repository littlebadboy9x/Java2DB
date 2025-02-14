/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository.Service;

import Repository.Domain.GiangVien;
import java.util.List;

/**
 *
 * @author Tran Viet Vuong
 */
public interface ISrGiangVien {

    List<GiangVien> getData();

    void them(List<GiangVien> lists, GiangVien gv);

    void xoa(List<GiangVien> lists, String ma);

    void sortByName(List<GiangVien> lists);

    void update(List<GiangVien> lists, String ma, GiangVien gv);
    

}
