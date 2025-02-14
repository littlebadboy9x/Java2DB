package Repository.Service;

import Repository.Domain.GiangVien;
import Repository.View.GiangVienRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Repository.Service.ISrGiangVien;
import java.util.ArrayList;

/**
 *
 * @author Tran Viet Vuong
 */
public class GiangVienService implements ISrGiangVien {

    private GiangVienRepository repo = new GiangVienRepository();

    public List<String> getLoaiGiangVien() {
        List<String> loaiList = new ArrayList<>();
        loaiList.add("Fulltime");
        loaiList.add("Parttime");
        return loaiList;
    }

    @Override
    public void them(List<GiangVien> lists, GiangVien gv) {
        if (repo.them(gv)) {
            lists.add(gv); // Thêm giảng viên vào danh sách
            System.out.println("Thêm thành công");
        } else {
            System.out.println("Thêm thất bại");
        }
    }

    @Override
    public void update(List<GiangVien> lists, String ma, GiangVien gv) {
        // In ra danh sách giảng viên hiện tại
        System.out.println("Danh sách giảng viên hiện tại:");
        for (GiangVien g : lists) {
            System.out.println("Mã: " + g.getMa());
        }

        // Kiểm tra xem giảng viên có mã tương ứng có tồn tại trong danh sách không
        boolean exists = lists.stream().anyMatch(g -> g.getMa().trim().equals(ma.trim()));

        if (!exists) {
            System.out.println("Giảng viên với mã " + ma + " không tồn tại trong danh sách.");
            return;
        }

        // Cập nhật thông tin giảng viên trong cơ sở dữ liệu
        if (repo.update(gv)) {
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i).getMa().trim().equals(ma.trim())) {
                    lists.set(i, gv); // Cập nhật giảng viên trong danh sách
                    System.out.println("Cập nhật thành công");
                    return;
                }
            }
        } else {
            System.out.println("Cập nhật thất bại");
        }
    }

    @Override
    public void xoa(List<GiangVien> lists, String ma) {
        if (repo.xoa(ma)) {
            lists.removeIf(gv -> gv.getMa().equals(ma)); // Xóa giảng viên khỏi danh sách
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    @Override
    public void sortByName(List<GiangVien> lists) {
        Collections.sort(lists, new Comparator<GiangVien>() {
            @Override
            public int compare(GiangVien gv1, GiangVien gv2) {
                return gv1.getTen().compareToIgnoreCase(gv2.getTen()); // Sắp xếp không phân biệt chữ hoa chữ thường
            }
        });
    }

    @Override
    public List<GiangVien> getData() {
        List<GiangVien> lists = repo.getAll();
        return lists;
    }

}
