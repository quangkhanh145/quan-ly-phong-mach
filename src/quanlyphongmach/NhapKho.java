package quanlyphongmach;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Quang Khanh
 */
public class NhapKho extends Scene{
    static BorderPane border = new BorderPane();
    public NhapKho()
    {
        super(border);
        CreateMenu();
        getStylesheets().add(QuanLyPhongMach.class.getResource("/css/nhapkho.css").toExternalForm());
    }
    
    public void CreateMenu()
    {
        Label TrangChu = new Label("Trang chủ");
        TrangChu.getStyleClass().add("label-menu");
        TrangChu.setOnMouseClicked(e->
        {
            SceneController.setHomePagePanel();
        });
        Label BenhNhan = new Label("Bệnh nhân");
        BenhNhan.getStyleClass().add("label-menu");
        BenhNhan.setOnMouseClicked(e->
        {
            SceneController.setBenhNhanPanel();
        });
        Label DonThuoc= new Label("Đơn thuốc");
        DonThuoc.getStyleClass().add("label-menu");
        DonThuoc.setOnMouseClicked(e->
        {
            SceneController.setDonThuocPanel();
        });
        Label HoaDon = new Label("Hoá đơn");
        HoaDon.getStyleClass().add("label-menu");
        HoaDon.setOnMouseClicked(e->
        {
            SceneController.setHoaDonPanel();
        });
        Label Thuoc = new Label("Thuốc");
        Thuoc.getStyleClass().add("label-menu");
        Thuoc.setOnMouseClicked(e->
        {
            SceneController.setThuocPanel();
        });
        Label NhapKho = new Label("Nhập kho");
        NhapKho.setId("NhapKho");
        NhapKho.getStyleClass().add("label-menu");
        Label BaoCao = new Label("Báo cáo");
        BaoCao.getStyleClass().add("label-menu");
        Label CauHinh = new Label("Cấu hình");
        CauHinh.getStyleClass().add("label-menu");
        
        HBox menu = new HBox(50);
        menu.setId("menu");
        menu.setPadding(new Insets(10,20,10,20));
        menu.setAlignment(Pos.TOP_CENTER);
        menu.getChildren().addAll(TrangChu, BenhNhan, DonThuoc, HoaDon, 
                Thuoc, NhapKho, BaoCao, CauHinh);
                
        Label lb_DanhSachNhapKho = new Label("Danh sách nhập kho");
        lb_DanhSachNhapKho.getStyleClass().add("menu2");
        
        Label  lb_NhaCungCap = new Label("Nhà cung cấp");
         lb_NhaCungCap.getStyleClass().add("menu2");
        
        HBox label_hbox = new HBox(10);
        label_hbox.setAlignment(Pos.TOP_CENTER);
        label_hbox.getChildren().addAll(lb_DanhSachNhapKho,  lb_NhaCungCap);
        
        BorderPane Bdmenu = new BorderPane();
        Bdmenu.setId("bdmenu");
        
        Bdmenu.setTop(menu);
        Bdmenu.setCenter(label_hbox);
        Bdmenu.setBottom(submenuDSNhapKho());
        
        border.setTop(Bdmenu);
        border.setLeft(left_Group());
        border.setCenter(tb_DSNhapKho());
        
        lb_DanhSachNhapKho.setOnMouseClicked(e->
        {
            Bdmenu.setBottom(submenuDSNhapKho());
            border.setLeft(left_Group());
            border.setCenter(tb_DSNhapKho());
        });
        
        lb_NhaCungCap.setOnMouseClicked(e->
        {
            Bdmenu.setBottom(submenuNhaCungCap());
            border.setCenter(tb_NhaCungCap());
        });
    }
    
    private HBox submenuDSNhapKho()
    {
        Text DanhSachNhapKho = new Text("Danh sách nhập kho");
        DanhSachNhapKho.getStyleClass().add("label-submenu");
        TextField tfTimKiem = new TextField();
        tfTimKiem.setPromptText("Nhập từ khoá");
        tfTimKiem.setFocusTraversable(false);
        DatePicker fromDay = new DatePicker();
        fromDay.setPromptText("Từ ngày");
        fromDay.setFocusTraversable(false);
        DatePicker toDay = new DatePicker();
        toDay.setPromptText("Đến ngày");
        toDay.setFocusTraversable(false);
        
        Rectangle iconTimKiem = new Rectangle(50,30);
        iconTimKiem.getStyleClass().add("icon");
        iconTimKiem.setFill(Color.web("#FFCF75"));
        Text txtTimKiem = new Text("Tìm");
        txtTimKiem.setMouseTransparent(true);
        txtTimKiem.setId("txtTimKiem");
        txtTimKiem.setFill(Color.BLACK);
        
        Rectangle iconThemPhieuNhap = new Rectangle(120,30);
        iconThemPhieuNhap.getStyleClass().add("icon");
        iconThemPhieuNhap.setFill(Color.web("#FFCF75"));
        Text txtThemPN = new Text("+ Thêm phiếu nhập");
        txtThemPN.setMouseTransparent(true);
        txtThemPN.setId("txtThemPN");
        
        StackPane stackThemPN = new StackPane();
        stackThemPN.getChildren().addAll(iconThemPhieuNhap, txtThemPN);
        stackThemPN.setAlignment(Pos.CENTER_RIGHT);
        stackThemPN.setMargin(txtThemPN,new Insets(0,5,0,0));
        stackThemPN.setPadding(new Insets(0,0,5,0));
        
        StackPane stack = new StackPane();
        stack.getChildren().addAll(iconTimKiem, txtTimKiem);
        stack.setAlignment(Pos.CENTER);
        stack.setPadding(new Insets(0,0,5,0));
        HBox submenu = new HBox(10);
        submenu.setPadding(new Insets(10,10,5,20));
        submenu.setHgrow(stackThemPN,Priority.ALWAYS);
        submenu.getChildren().addAll(DanhSachNhapKho, tfTimKiem, fromDay, toDay, stack,stackThemPN);
        
        return submenu;
    }
    
    private VBox tb_DSNhapKho()
    {
        TableView tb = new TableView();
        tb.setEditable(true);
        TableColumn maSoCol = new TableColumn("Mã số");
        maSoCol.setPrefWidth(100);
        TableColumn nhaCungCapCol = new TableColumn("Nhà cung cấp");
        nhaCungCapCol.setPrefWidth(150);
        TableColumn nguoiLapCol = new TableColumn("Người lập");
        nguoiLapCol.setPrefWidth(150);
        TableColumn ngayLapCol = new TableColumn("Ngày lập");
        ngayLapCol.setPrefWidth(100);
        TableColumn tongHoaDon = new TableColumn("Tổng hóa đơn");
        tongHoaDon.setPrefWidth(100);
        TableColumn chucNangCol = new TableColumn("Chức năng");
        chucNangCol.setPrefWidth(80);
        
        tb.getColumns().addAll(maSoCol, nhaCungCapCol, nguoiLapCol, ngayLapCol,
                tongHoaDon, chucNangCol);
        VBox vb = new VBox(10);
        vb.getChildren().add(tb);
        return vb;
    }
    
    private HBox submenuNhaCungCap()
    {
        Text QLNhaCungCap = new Text("Quản lý nhà cung cấp");
        QLNhaCungCap.getStyleClass().add("label-submenu");
        TextField tfTimKiem = new TextField();
        tfTimKiem.setPromptText("Nhập từ khoá");
        tfTimKiem.setFocusTraversable(false);
        Rectangle iconTimKiem = new Rectangle(50,30);
        iconTimKiem.getStyleClass().add("icon");
        iconTimKiem.setFill(Color.web("#FFCF75"));
        Text txtTimKiem = new Text("Tìm");
        txtTimKiem.setMouseTransparent(true);
        txtTimKiem.setId("txtTimKiem");
        txtTimKiem.setFill(Color.BLACK);
        
        Rectangle iconThemNhaCC = new Rectangle(130,30);
        iconThemNhaCC.getStyleClass().add("icon");
        iconThemNhaCC.setFill(Color.web("#FFCF75"));
        Text txtThemNhaCC = new Text("+ Thêm nhà cung cấp");
        txtThemNhaCC.setMouseTransparent(true);
        txtThemNhaCC.setId("txtThemNhaCC");
        
        StackPane stackThemNhaCC = new StackPane();
        stackThemNhaCC.getChildren().addAll(iconThemNhaCC, txtThemNhaCC);
        stackThemNhaCC.setAlignment(Pos.CENTER_RIGHT);
        stackThemNhaCC.setMargin(txtThemNhaCC,new Insets(0,5,0,0));
        stackThemNhaCC.setPadding(new Insets(0,0,5,0));
        
        StackPane stack = new StackPane();
        stack.getChildren().addAll(iconTimKiem, txtTimKiem);
        stack.setAlignment(Pos.CENTER);
        stack.setPadding(new Insets(0,0,5,0));
        HBox submenu = new HBox(10);
        submenu.setPadding(new Insets(10,10,5,20));
        submenu.setHgrow(stackThemNhaCC,Priority.ALWAYS);
        submenu.getChildren().addAll(QLNhaCungCap, tfTimKiem, stack,stackThemNhaCC);
        
        return submenu;
    }
    
    private VBox tb_NhaCungCap()
    {
        TableView tb = new TableView();
        tb.setEditable(true);
        TableColumn maCol = new TableColumn("Mã");
        maCol.setPrefWidth(100);
        TableColumn tenCol = new TableColumn("Tên");
        tenCol.setPrefWidth(100);
        TableColumn dienThoaiCol = new TableColumn("Điện thoại");
        dienThoaiCol.setPrefWidth(100);
        TableColumn diaChiCol = new TableColumn("Địa chỉ");
        diaChiCol.setPrefWidth(150);
        TableColumn nhomCol = new TableColumn("Nhóm");
        nhomCol.setPrefWidth(100);
        TableColumn ngayLapCol = new TableColumn("Ngày lập");
        ngayLapCol.setPrefWidth(120);
        TableColumn chucNangCol = new TableColumn("Chức năng");
        chucNangCol.setPrefWidth(80);
        
        tb.getColumns().addAll(maCol, tenCol, dienThoaiCol, diaChiCol,
                nhomCol, ngayLapCol,chucNangCol);
        VBox vb = new VBox(10);
        vb.getChildren().add(tb);
        return vb;
    }
    
    private VBox left_Group()
    {
        Text group = new Text("Nhóm");
        group.setId("group");
        Text AddGroup = new Text("+");
        AddGroup.setId("AddGroup");
        GridPane grid = new GridPane();
        grid.add(AddGroup, 0, 0);
        grid.setAlignment(Pos.CENTER_RIGHT);
        HBox HBoxGroup = new HBox(10);
        HBoxGroup.setHgrow(grid,Priority.ALWAYS);
        HBoxGroup.getChildren().addAll(group, grid);
        HBoxGroup.setPadding(new Insets(15,5,10,5));
        
        Rectangle rec1 = new Rectangle(250,30);
        rec1.getStyleClass().add("rec");
        Text txt1 = new Text("Tất cả");
        txt1.setMouseTransparent(true);
        txt1.getStyleClass().add("txt");
        StackPane stk1 = new StackPane();
        stk1.getStyleClass().add("stk");
        stk1.setAlignment(Pos.CENTER_LEFT);
        stk1.setMargin(txt1, new Insets(0,0,0,10));
        stk1.getChildren().addAll(rec1, txt1);
        
        VBox vbgroup = new VBox(10);
        vbgroup.getChildren().addAll(HBoxGroup, stk1);
        
        return vbgroup;
    }
    
}
