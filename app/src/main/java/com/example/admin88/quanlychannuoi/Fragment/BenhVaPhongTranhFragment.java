package com.example.admin88.quanlychannuoi.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin88.quanlychannuoi.ActivityChiTiet.ChiTietbenhActivity;
import com.example.admin88.quanlychannuoi.Adapter.AdapterChiTietbenh;
import com.example.admin88.quanlychannuoi.R;
import com.example.admin88.quanlychannuoi.model.ChitietBenh;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BenhVaPhongTranhFragment extends Fragment {

   private RecyclerView ryc_chitietbenh;
   private List<ChitietBenh> chitietBenhs;
   private ChitietBenh chitietBenh;
   private AdapterChiTietbenh adapterChiTietbenh;

    public BenhVaPhongTranhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_benh_va_phong_tranh, container, false);
        ryc_chitietbenh = v.findViewById(R.id.ryc_chitietbenh);
        ryc_chitietbenh.setLayoutManager(new LinearLayoutManager(getActivity()));
        chitietBenhs = new ArrayList<>();
        chitietBenhs.add(new ChitietBenh("Bệnh dịch tả","Hiện tại chưa có thuốc đặc trị nhưng bà con phải tiêm phòng Vắc xin đúng lịch trình, khi lợn mới mua về phải nhốt riêng ra ít nhất 3 tuần, để tránh trường hợp lợn lây bệnh cho đàn. Chuồng trại phải luôn vệ sinh định kỳ, sát trùng, khi có dịch xảy ra lợn bệnh phải được xử lý ngay kịp thời."));
        chitietBenhs.add(new ChitietBenh("Bệnh phó thương hàn","Bệnh phó thương hàn có triệu chứng rất giống với bệnh dịch tả và thường ghép với bệnh dịch tả. Mình phải dùng thuốc kháng sinh đặc trị để kiểm tra xem có phải bị bệnh dịch tả hay phó thương hàn. Những loại thuốc có hiệu quả với vi khuẩn salmonella sinh ra bệnh phó thương hàn bao gồm: Oxytetramycin (ít có tác dụng), Flumequin (rất tốt), Colistine (Tốt), Amoxylin (Tốt), Neomycin( kém), Enrofloxacin ( tốt), Ampicyclin (tốt), Flophenicol (tốt), Kanamycin (Trung bình)."));
        chitietBenhs.add(new ChitietBenh("Bệnh đóng dấu lợn","Lợn khỏe mạnh: Để phòng bệnh bà con cần chọn giống lợn tốt chỗ uy tín, môi trường sạch sẽ, thoáng mát và tiêm phòng vacxin cho lợn định kỳ. Đặc biệt bà con cần chú ý kỹ đến chế độ ăn của từng giai đoạn của lợn.\n" +
                "– Lợn mắc bệnh: Hiện nay thì chưa có thuốc đặc trị bệnh. Vì vậy bà con có thể tăng cường sức đề kháng cho lợn như phun thuốc sát trùng, tiêm thuốc kháng sinh định kỳ cho lợn."));
        chitietBenhs.add(new ChitietBenh("Bệnh lở mồm long móng","Người chăn nuôi phải thường xuyên quan sát đàn vật nuôi, khi thấy gia súc có hiện tượng lạ như sốt, bỏ ăn, chảy nước dãi, có bọt có mụn nước ở vùng miệng và quanh móng chân phải tiến hành cách ly ngay."));
        chitietBenhs.add(new ChitietBenh("Bệnh viêm phổi địa phương"," Phác đồ 1: Dùng thuốc Plastilin trộn vào thức ăn, nước uống với liều lượng 1g/2-3kg thể trọng."));
        chitietBenhs.add(new ChitietBenh("Bệnh tiêu hóa","Khi phát hiện lợn con ỉa phân trắng bà con cần kiểm tra ngay nguồn thức ăn có phải là nguyên nhân không, đồng thời tiêm hoặc cho lợn uống thuốc theo chỉ dẫn của cán bộ thú y và người bán thuốc. Lợn con ỉa phân trắng không chữa trị kịp thời tỷ lệ chết từ 5 – 20%. Lợn con đã tách mẹ thỉnh thoảng bị đi ỉa chảy bà con không cần phải cho uống thuốc do bộ phận tiêu hoá của lợn ở giai đoạn này đã phát triển nên chúng chỉ bị 1 – 2 hôm rồi lại tự khỏi. Nói chung khi lợn con đã tách mẹ ( tự ăn được) thì bệnh đi ỉa không còn là vấn đề đáng lo ngại nữa."));
        chitietBenhs.add(new ChitietBenh("Bệnh ghẻ lở","Bệnh này xuất hiện ở tất cả đàn lợn, biểu hiện của bệnh này là da mốc, nứt nẻ, lông dụng, lợn ngứa hay lấy chân gãi hoặc cọ vào tường. Khi thấy triệu chứng trên cần tiêm hoặc bôi thuốc ngay, tốt nhất là tiêm vì hiệu quả cao hơn. Liều lượng theo chỉ dẫn trên bao bì mỗi loại thuốc. Nhìn chung khi lợn mắc phải bệnh này nếu phát hiện sớm và chữa trị kịp thời thì khả năng khỏi bệnh là 100% và là loại bệnh không quá phải lo ngại."));
        chitietBenhs.add(new ChitietBenh("Bệnh phổi “ Thở dốc”","Nguyên nhân của loại bệnh này là do thời tiết thay đổi, chuồng trại ẩm thấp, không đảm bảo vệ sinh. Đây là loại bệnh tương đối nguy hiểm và có cơ chế truyền nhiễm.Vì vậy, nếu phát hiện lợn bị bệnh tốt nhất là cách li ngay và tiêm thuốc.\n" +
                "\n" +
                "Triệu chứng là lợn bỏ ăn, lông xù, chậm chạp và thở dốc, bệnh phát triển rất nhanh, sáng cho ăn vẫn bình thường nhưng có thể đến trưa triệu chứng của bệnh đã rõ, bệnh thường xuất hiện ở loại từ 10 – 25kg. Nếu chữa trị kịp thời thì khả năng khỏi bệnh là 95%, không chữa trị hoặc chữa trị không kịp thời (Để 2 – 3 ngày sau mới tiêm) thì khả năng tử vong là 70%. Đây là loại bệnh đáng lo ngại, bà con cần phải hết sức lưu tâm"));
        chitietBenhs.add(new ChitietBenh("Bệnh phù nề","Cũng thường xuất hiện ở lợn từ 10 – 25 kg. Nguyên nhân do chuồng trại ẩm thấp, không vệ sinh, nguồn thức ăn thay đổi đột ngột, lợn vận chuyển lâu ngày qua các vùng địa lý khác nhau.\n" +
                "\n" +
                "Triệu chứng của bệnh là mắt đỏ rồi sưng vành mi mắt, sưng đầu, đi loạng choạng, lao đầu về phía trước. Đây là bệnh cực kỳ nguy hiểm, khi bị mắc bệnh này thì khả năng chữa khỏi bệnh gần như là không thể. Nên áp dụng các biện pháp để phòng ngừa là giải pháp tối ưu"));
        adapterChiTietbenh = new AdapterChiTietbenh( chitietBenhs, getActivity());
        ryc_chitietbenh.setAdapter(adapterChiTietbenh);
        return v;
    }

}
