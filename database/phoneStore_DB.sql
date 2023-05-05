--
-- Tạo Database
--

CREATE DATABASE DoAn
GO
USE DoAn

--
-- Cấu trúc bảng CT_PHIEUNHAP
--

CREATE TABLE CT_PHIEUNHAP (
	MaSP varchar(10) not null,
	MaPN varchar(10) not null,
	SoLuong int not null,
	ThanhTien int not null,
	DonGiaNhap int not null
)

--
-- Đổ dữ liệu cho bảng CT_PHIEUNHAP
--



--
-- Cấu trúc bảng CT_SP
--

CREATE TABLE CT_SP (
	MaSP varchar(10) not null,
	MaLoai varchar(10) not null,
	MaHang varchar(10) not null,
	MoTaSP varchar(50) not null
)

-- 
-- Đổ dữ liệu cho bảng CT_SP
--



--
-- Cấu trúc bảng CTHD
--

CREATE TABLE CTHD (
	MaSP varchar(10) not null,
	MaHD varchar(10) not null,
	DonGia int not null,
	SoLuong int not null,
	ThanhTien int not null
)

--
-- Đổ dữ liệu cho bảng CTHD
--



--
-- Cấu trúc bảng CTKM
--

CREATE TABLE CTKM (
	MaKM varchar(10) not null,
	MaHD varchar(10) not null,
	TenKM varchar(20) not null,
	NgayBD date not null,
	NgayKT date not null,
	PhanTramGiam int not null
)

-- 
-- Đổ dữ liệu cho bảng CTKM
--



--
-- Cấu trúc bảng HANG_SX
--

CREATE TABLE HANG_SX (
	MaHang varchar(10) not null,
	TenHang varchar(20) not null
)

--
-- Đổ dữ liệu cho bảng HANG_SX
--



--
-- Cấu trúc bảng HOADON
--

CREATE TABLE HOADON (
	MaHD varchar(10) not null,
	MaNV varchar(10) not null,
	MaKH varchar(10) not null,
	NgayLap date not null,
	TongTien int not null,
	TienGiam int not null,
	ConLai int not null
)

--
-- Đổ dữ liệu cho bảng HOADON
--


--
-- Cấu trúc bảng KHACHHANG
--

CREATE TABLE KHACHHANG (
	MaKH varchar(10) not null,
	Ten varchar(10) not null,
	HoLot varchar(20) not null,
	DiaChi varchar(20) not null,
	SDT varchar(10) not null
)
GO
ALTER TABLE KHACHHANG
	ADD Username VARCHAR(50) not null,
	    Pass VARCHAR(50) not null;

-- 
-- Đổ dữ liệu cho bảng KHACHHANG
--




--
-- Cấu trúc bảng LOAI_SP
--

CREATE TABLE LOAI_SP (
	MaLoai varchar(10) not null,
	TenLoai varchar(10) not null
)

-- 
-- Đổ dữ liệu cho bảng LOAI_SP
-- 



--
-- Cấu trúc bảng NHACUNGCAP
--

CREATE TABLE NHACUNGCAP (
	MaNCC varchar(10) not null,
	TenNCC varchar(20) not null,
	DiaChi varchar(20) not null,
	SDT varchar(10) not null
)

--
-- Đổ dữ liệu cho  varbảng NHACUNGCAP
--



--
-- Cấu trúc bảng NHANVIEN
--

CREATE TABLE NHANVIEN (
	MaNV varchar(10) not null,
	Ten varchar(10) not null,
	HoLot varchar(20) not null,
	DiaChi varchar(20) not null,
	SDT varchar(10) not null,
	Luong int not null
)
GO
ALTER TABLE NHANVIEN
	ADD Username VARCHAR(50) not null,
	    Pass VARCHAR(50) not null;

--
-- Đổ dữ liệu cho bảng NHANVIEN
--



-- 
-- Cấu trúc bảng PHIEUNHAP
--

CREATE TABLE PHIEUNHAP (
	MaPN varchar(10) not null,
	NgayLap date not null,
	TongTien int not null,
	MaNCC varchar(10) not null,
	MaNV varchar(10) not null
)

-- 
-- Đổ dữ liệu cho bảng SANPHAM
--

CREATE TABLE SANPHAM (
	MaSP varchar(10) not null,
	TenSP varchar(20) not null,
	SoLuong int not null,
	DonGia int not null,
	DonViTinh varchar(10) not null,
	MaLoai varchar(10) not null
)	

--
-- Đổ dữ liệu cho bảng SANPHAM
--


--
-- Chỉ mục cho bảng CTHD
--

ALTER TABLE CTHD ADD CONSTRAINT MaSP_PK_CTHD PRIMARY KEY (MaSP)

--
-- Chỉ mục cho bảng CTKM
--

ALTER TABLE CTKM ADD CONSTRAINT MaKM_PK_CTKM PRIMARY KEY (MaKM)

--
-- Chỉ mục cho bảng HANG_SX
--

ALTER TABLE HANG_SX ADD CONSTRAINT MaHang_PK_HANG_SX PRIMARY KEY (MaHang)

--
-- Chỉ mục cho bảng HOADON
--

ALTER TABLE HOADON ADD CONSTRAINT MaHD_PK_HOADON PRIMARY KEY (MaHD)

--
-- Chỉ mục cho bảng KHACHHANG
--

ALTER TABLE KHACHHANG ADD CONSTRAINT MaKH_PK_KHACHHANG PRIMARY KEY (MaKH)

--
-- Chỉ mục cho bảng LOAI_SP
--

ALTER TABLE LOAI_SP ADD CONSTRAINT MaLoai_PK_LOAI_SP PRIMARY KEY (MaLoai)

--
-- Chỉ mục cho bảng NHACUNGCAP
--

ALTER TABLE NHACUNGCAP ADD CONSTRAINT MaNCC_PK_NCC PRIMARY KEY (MaNCC)

--
-- Chỉ mục cho bảng NHANVIEN
--

ALTER TABLE NHANVIEN ADD CONSTRAINT MaNV_PK_NHANVIEN PRIMARY KEY (MaNV)

--
-- Chỉ mục cho bảng PHIEUNHAP
--

ALTER TABLE PHIEUNHAP ADD CONSTRAINT MaPN_PK_PN PRIMARY KEY (MaPN)

--
-- Chỉ mục cho bảng SANPHAM
--

ALTER TABLE SANPHAM ADD CONSTRAINT MaSP_PK_SP PRIMARY KEY (MaSP)

--
-- Các ràng buộc cho bảng CT_PHIEUNHAP
--

ALTER TABLE CT_PHIEUNHAP ADD FOREIGN KEY (MaSP) REFERENCES SANPHAM (MaSP)
ALTER TABLE CT_PHIEUNHAP ADD FOREIGN KEY (MaPN) REFERENCES PHIEUNHAP (MaPN)

--
-- Các ràng buộc cho bảng CT_SP
--

ALTER TABLE CT_SP ADD FOREIGN KEY (MaSP) REFERENCES SANPHAM (MaSP)
ALTER TABLE CT_SP ADD FOREIGN KEY (MaLoai) REFERENCES LOAI_SP (MaLoai)
ALTER TABLE CT_SP ADD FOREIGN KEY (MaHang) REFERENCES HANG_SX (MaHang)

--
-- Các ràng buộc cho bảng CTHD
--

ALTER TABLE CTHD ADD FOREIGN KEY (MaSP) REFERENCES SANPHAM (MaSP)
ALTER TABLE CTHD ADD FOREIGN KEY (MaHD) REFERENCES HOADON (MaHD)

--
-- Các ràng buộc cho bảng CTKM
--

ALTER TABLE CTKM ADD FOREIGN KEY (MaHD) REFERENCES HOADON (MaHD)

--
-- Các ràng buộc cho bảng HOADON
--

ALTER TABLE HOADON ADD FOREIGN KEY (MaNV) REFERENCES NHANVIEN (MaNV)
ALTER TABLE HOADON ADD FOREIGN KEY (MaKH) REFERENCES KHACHHANG (MaKH)

--
-- Các ràng buộc cho bảng PHIEUNHAP
--

ALTER TABLE PHIEUNHAP ADD FOREIGN KEY (MaNCC) REFERENCES NHACUNGCAP (MaNCC)



