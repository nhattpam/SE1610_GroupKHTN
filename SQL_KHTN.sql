USE [master]
GO
/****** Object:  Database [NestSongAn]    Script Date: 04/11/2022 3:54:10 CH ******/
CREATE DATABASE [NestSongAn]

ALTER DATABASE [NestSongAn] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [NestSongAn].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [NestSongAn] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [NestSongAn] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [NestSongAn] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [NestSongAn] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [NestSongAn] SET ARITHABORT OFF 
GO
ALTER DATABASE [NestSongAn] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [NestSongAn] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [NestSongAn] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [NestSongAn] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [NestSongAn] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [NestSongAn] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [NestSongAn] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [NestSongAn] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [NestSongAn] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [NestSongAn] SET  DISABLE_BROKER 
GO
ALTER DATABASE [NestSongAn] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [NestSongAn] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [NestSongAn] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [NestSongAn] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [NestSongAn] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [NestSongAn] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [NestSongAn] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [NestSongAn] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [NestSongAn] SET  MULTI_USER 
GO
ALTER DATABASE [NestSongAn] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [NestSongAn] SET DB_CHAINING OFF 
GO
ALTER DATABASE [NestSongAn] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [NestSongAn] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [NestSongAn] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [NestSongAn] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [NestSongAn] SET QUERY_STORE = OFF
GO
USE [NestSongAn]
GO
/****** Object:  Table [dbo].[branch]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[branch](
	[branch_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](45) NULL,
	[location_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[branch_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[feedback]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[feedback](
	[feedback_id] [int] IDENTITY(1,1) NOT NULL,
	[feedback] [nvarchar](100) NULL,
	[user_id] [int] NULL,
	[create_date] [varchar](50) NULL,
	[product_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[feedback_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[import_invoice]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[import_invoice](
	[import_invoice_id] [int] IDENTITY(1,1) NOT NULL,
	[branch_id] [int] NULL,
	[product_id] [int] NULL,
	[quantity] [varchar](45) NULL,
	[import_date] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[import_invoice_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[location]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[location](
	[location_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[location_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order](
	[order_id] [varchar](255) NOT NULL,
	[delivery_address] [nvarchar](255) NULL,
	[payment_method] [nvarchar](40) NULL,
	[order_date] [varchar](50) NULL,
	[delivery_date] [varchar](50) NULL,
	[total_price] [float] NULL,
	[status] [int] NULL,
	[user_id] [int] NULL,
	[shipper_id] [int] NULL,
	[note] [nvarchar](20) NULL,
	[location_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_details]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_details](
	[order_details_id] [int] IDENTITY(1,1) NOT NULL,
	[quantity] [int] NULL,
	[total_price] [float] NULL,
	[product_id] [int] NULL,
	[order_id] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[order_details_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[product_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](150) NULL,
	[code] [varchar](150) NULL,
	[short_description] [nvarchar](600) NULL,
	[full_description] [nvarchar](4000) NULL,
	[is_hot_selling] [bit] NULL,
	[is_outstanding] [bit] NULL,
	[is_latest] [bit] NULL,
	[weight] [int] NULL,
	[price] [float] NULL,
	[photo] [varchar](100) NULL,
	[create_date] [varchar](50) NULL,
	[edit_date] [varchar](50) NULL,
	[category_id] [int] NULL,
	[quantity] [int] NULL,
	[supplier_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[quantity_product]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[quantity_product](
	[product_id] [int] NULL,
	[branch_id] [int] NULL,
	[quantity] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_role]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_role](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[role] [varchar](45) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[full_name] [nvarchar](100) NULL,
	[user_name] [varchar](45) NULL,
	[password] [varchar](200) NULL,
	[email] [varchar](45) NULL,
	[phone] [varchar](10) NULL,
	[status] [int] NULL,
	[create_date] [varchar](50) NULL,
	[edited_date] [varchar](50) NULL,
	[role_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[wishlist]    Script Date: 04/11/2022 3:54:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[wishlist](
	[create_date] [varchar](50) NULL,
	[user_id] [int] NOT NULL,
	[product_id] [int] NOT NULL,
 CONSTRAINT [PK_wishlist] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[branch] ON 

INSERT [dbo].[branch] ([branch_id], [name], [location_id]) VALUES (1, N'Miền Bắc', 3)
INSERT [dbo].[branch] ([branch_id], [name], [location_id]) VALUES (2, N'Miền Trung', 2)
INSERT [dbo].[branch] ([branch_id], [name], [location_id]) VALUES (3, N'Miền Nam', 1)
SET IDENTITY_INSERT [dbo].[branch] OFF
GO
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([category_id], [name]) VALUES (1, N'Yến Hũ')
INSERT [dbo].[category] ([category_id], [name]) VALUES (2, N'Yến Tinh Chế')
INSERT [dbo].[category] ([category_id], [name]) VALUES (3, N'Yến Tươi')
INSERT [dbo].[category] ([category_id], [name]) VALUES (4, N'Yến Thô Còn Lông')
INSERT [dbo].[category] ([category_id], [name]) VALUES (5, N'Chân Tổ Yến')
INSERT [dbo].[category] ([category_id], [name]) VALUES (6, N'Nước Yến')
INSERT [dbo].[category] ([category_id], [name]) VALUES (7, N'Tổ Yến Huyết')
INSERT [dbo].[category] ([category_id], [name]) VALUES (8, N'Tổ Yến Hồng')
SET IDENTITY_INSERT [dbo].[category] OFF
GO
SET IDENTITY_INSERT [dbo].[feedback] ON 

INSERT [dbo].[feedback] ([feedback_id], [feedback], [user_id], [create_date], [product_id]) VALUES (1, N'ok', 2, N'10/17/22 10:09 PM', 19)
INSERT [dbo].[feedback] ([feedback_id], [feedback], [user_id], [create_date], [product_id]) VALUES (2, N'ok', 6, N'10/27/22 7:33 AM', 20)
INSERT [dbo].[feedback] ([feedback_id], [feedback], [user_id], [create_date], [product_id]) VALUES (3, N'ok', 2, N'10/27/22 9:08 AM', 7)
INSERT [dbo].[feedback] ([feedback_id], [feedback], [user_id], [create_date], [product_id]) VALUES (4, N'kk', 2, N'10/27/22 9:16 AM', 8)
SET IDENTITY_INSERT [dbo].[feedback] OFF
GO
SET IDENTITY_INSERT [dbo].[location] ON 

INSERT [dbo].[location] ([location_id], [name]) VALUES (1, N'Số 12, Đường 202, Khu phố 2, Phường An Phú, TP.Thủ Đức, TP.HCM')
INSERT [dbo].[location] ([location_id], [name]) VALUES (2, N'Số 255, Đường Ông Minh, Phường Hoà Hiệp Bắc, Quận Liên Chiểu, TP.Đà Nẵng')
INSERT [dbo].[location] ([location_id], [name]) VALUES (3, N'Số 22, Phường Trúc Bạch, Quận Ba Đình, Hà Nội')
SET IDENTITY_INSERT [dbo].[location] OFF
GO
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665900217126', N'123, Hoà Bình', N'cod', N'10/16/22 1:03 PM', NULL, 3200000, 3, 2, NULL, NULL, 3)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665903829217', N'123, Hoà Bình', N'cod', N'10/16/22 2:03 PM', NULL, 7000000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665927401937', N'1222, Điện Biên', N'cod', N'10/16/22 8:36 PM', NULL, 33320000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665932057918', N'44, Hà Giang', N'cod', N'10/16/22 9:54 PM', NULL, 7760000, 1, 7, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665933310815', N'123, Hoà Bình', N'cod', N'10/16/22 10:15 PM', NULL, 1090000, 1, 7, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665933470470', N'44, Cao Bằng', N'cod', N'10/16/22 10:17 PM', NULL, 12800000, 1, 7, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665935619763', N'f, Lạng Sơn', N'cod', N'10/16/22 10:53 PM', NULL, 15520000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665967072616', N'555, Tuyên Quang', N'cod', N'10/17/22 7:37 AM', NULL, 12020000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665967124328', N'f, Sơn La', N'cod', N'10/17/22 7:38 AM', NULL, 9280000, 1, 7, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665992111583', N'6, Bắc Ninh', N'cod', N'10/17/22 2:35 PM', NULL, 3040000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1665994752423', N'22121, Quảng Ninh', N'cod', N'10/17/22 3:19 PM', NULL, 760000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666006871031', N'44, Sơn La', N'cod', N'10/17/22 6:41 PM', NULL, 760000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666008545886', N'999999999999, Hưng Yên', N'cod', N'10/17/22 7:09 PM', NULL, 5.6999998092651367, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666008834450', N'dang ccw, Nghệ An', N'cod', N'10/17/22 7:13 PM', NULL, 5.6999998092651367, 1, 7, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666012108557', N'6, Hà Giang', N'cod', N'10/17/22 8:08 PM', NULL, 5.6999998092651367, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666012175919', N'khong , Tuyên Quang', N'cod', N'10/17/22 8:09 PM', NULL, 5.6999998092651367, 1, 7, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666012483291', N'123, Cao Bằng', N'cod', N'10/17/22 8:14 PM', NULL, 5.6999998092651367, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666014977055', N'123, Hoà Bình', N'cod', N'10/17/22 8:56 PM', NULL, 3500000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666015097386', N'thai nguyen, Thái Nguyên', N'cod', N'10/17/22 8:58 PM', NULL, 5020000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666015259964', N'123, Sơn La', N'cod', N'10/17/22 9:00 PM', NULL, 19060000, 1, 7, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666017135273', N'44, Hoà Bình', N'cod', N'10/17/22 9:32 PM', NULL, 24040000, 1, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666054634553', N'44, Điện Biên', N'cod', N'10/18/22 7:57 AM', NULL, 3800000, 1, 7, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666836414532', N'fsdf, Hoà Bình', N'cod', N'10/27/22 9:06 AM', NULL, 16280000, 3, 2, NULL, NULL, 3)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666836583354', N'he lo, Sơn La', N'cod', N'10/27/22 9:09 AM', NULL, 21760000, 3, 2, NULL, NULL, NULL)
INSERT [dbo].[order] ([order_id], [delivery_address], [payment_method], [order_date], [delivery_date], [total_price], [status], [user_id], [shipper_id], [note], [location_id]) VALUES (N'1666836760183', N'he, Hà Giang', N'cod', N'10/27/22 9:12 AM', NULL, 52500000, 3, 7, NULL, NULL, 2)
GO
SET IDENTITY_INSERT [dbo].[order_details] ON 

INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (1, 1, 3200000, 20, N'1665900217126')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (2, 2, 3500000, 7, N'1665903829217')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (3, 8, 3500000, 7, N'1665927401937')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (4, 7, 760000, 8, N'1665927401937')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (5, 2, 3500000, 7, N'1665932057918')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (6, 1, 760000, 8, N'1665932057918')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (7, 1, 1090000, 19, N'1665933310815')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (8, 4, 3200000, 20, N'1665933470470')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (9, 4, 3500000, 7, N'1665935619763')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (10, 2, 760000, 8, N'1665935619763')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (11, 3, 3500000, 7, N'1665967072616')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (12, 2, 760000, 8, N'1665967072616')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (13, 2, 3500000, 7, N'1665967124328')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (14, 3, 760000, 8, N'1665967124328')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (15, 4, 760000, 8, N'1665992111583')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (16, 1, 760000, 8, N'1665994752423')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (17, 1, 760000, 8, N'1666006871031')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (18, 1, 3500000, 7, N'1666008545886')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (19, 3, 3500000, 7, N'1666008834450')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (20, 4, 760000, 8, N'1666008834450')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (21, 1, 3500000, 7, N'1666012108557')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (22, 2, 760000, 8, N'1666012108557')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (23, 3, 2300000, 15, N'1666012175919')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (24, 2, 3200000, 20, N'1666012175919')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (25, 1, 3500000, 7, N'1666012483291')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (26, 2, 760000, 8, N'1666012483291')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (27, 1, 3500000, 7, N'1666014977055')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (28, 2, 760000, 8, N'1666015097386')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (29, 1, 3500000, 9, N'1666015097386')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (30, 3, 4900000, 16, N'1666015259964')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (31, 4, 1090000, 19, N'1666015259964')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (32, 4, 760000, 8, N'1666017135273')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (33, 6, 3500000, 9, N'1666017135273')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (34, 5, 760000, 8, N'1666054634553')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (35, 4, 3500000, 7, N'1666836414532')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (36, 3, 760000, 8, N'1666836414532')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (37, 6, 3500000, 7, N'1666836583354')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (38, 1, 760000, 8, N'1666836583354')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (39, 6, 3500000, 7, N'1666836760183')
INSERT [dbo].[order_details] ([order_details_id], [quantity], [total_price], [product_id], [order_id]) VALUES (40, 9, 3500000, 9, N'1666836760183')
SET IDENTITY_INSERT [dbo].[order_details] OFF
GO
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (7, N'Yến Thô Đá (Đảo) Hộp 100g', N'YTD', N'Khai thác từ thiên nhiên 100% – Trọng lượng: 100g Tổ yến thô còn nguyên tổ và lông, tổ loại 2 sẽ lồi lõm không đều. Tổ yến thô loại 2 hộp 100g vẫn có vị tanh nhẹ đặc trưng của yến. Sản phẩm đã trải qua quá trình sấy khô trước khi đóng gói. Một hộp 100g có khoảng 10 – 12 tổ yến (để sử dụng).', N'Yến sào thô loại 2 được người dân trực tiếp thu hoạch từ các vách đá chênh vênh, đảm bảo tự nhiên 100%. Những tổ yến này sau khi thu thập sẽ được trộn lẫn vào nhau mà không cần phân chia kích thước. Đặc điểm nổi bật mà người dùng nhìn vào có thể nhận biết yến tự nhiên ở chỗ lông yến, bụi bẩn hay thậm chí phân yến vẫn còn bám trên tổ. Yến thô loại 2 hộp 100g đảm bảo được hàm lượng dinh dưỡng tối đa của tổ yến vì chưa qua sơ chế. Yến sẽ có mùi đặc trưng hơi tanh, đây cũng là điểm mà khách hàng có thể nhận biết yến thật và giả. Tai yến khi ngâm nước có thể nở ra gấp 4 – 5 lần bình thường. Sau khi làm sạch và  mang đi chưng sẽ cò mùi cực kì thơm, có độ giòn ngọt, dai dai. Việc làm sạch yến có thể tốn nhiều thời gian và công sức của người dùng. Nhưng điều đó hoàn toàn xứng đáng vì người dùng sẽ được thưởng thức trọn vẹn hương vị cũng như hấp thụ toàn bộ dưỡng chất dinh dưỡng của  tổ yến. Điểm này đã làm nên khác biệt và sự thu hút hút của yến thô loại 2 so với các loại yến tinh chế.Dùng trong gia đình: Người có thể mua tổ yến thô thiên nhiên loại 2 về chế biến cho gia đình để bồi bổ sức khỏe. Các thành viên quây quần bên nhau, làm sạch yến và chưng nồi yến thơm ngon, bổ dưỡng sẽ giúp tăng tình cảm gia đình. Bên cạnh đó, yến chứa hàm lượng dinh dưỡng cao, không chứa các chất hóa học, rất thích hợp với đối tượng trẻ nhỏ, người già, phụ nữ có thai, người sức khỏe kém,…..', 0, 0, 0, 100, 3500000, N'hop-yen-huyet-tho-100g-thuong-hang.jpg', N'10/9/22 1:24 PM', NULL, 4, 50, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (8, N'Yến Đảo (Đá) THÔ Loại Thượng Hạng 20g', N'YDT20', N'Khai thác từ thiên nhiên 100% – Trọng lượng: 20g Tổ yến đảo thô còn nguyên tổ và lông, đảm bảo giữ nguyên giá trị dinh dưỡng Tổ yến đảo thô nguyên tổ 20g vẫn có vị tanh nhẹ đặc trưng của yến. Sản phẩm đã trải qua quá trình sấy khô trước khi đóng gói.', N'Yến đảo thô nguyên tổ 20g là loại thực phẩm chức năng được khai thác nguyên chất 100%, có chứa nhiều chất dinh dưỡng tốt nhất cho cơ thể mang lại nhiều tác dụng phục hồi sức khoẻ nhanh chóng cho mọi đối tượng bao gồm trẻ em, người lớn, người bệnh, người già,…. Yến đảo thô nguyên tổ 20g là tổ yến nguyên bản 100% chưa trải qua bất kì quy trình xử lý làm sạch nào, vẫn còn lông chim, bụi bẩn và các tạp chất khác và đặc biệt còn giữ mùi tanh đặc trưng của yến, cũng chính vì vậy mà các tổ yến đá thô cao cấp 20g vẫn còn giữ nguyên vẹn hàm lượng chất dinh dưỡng vốn có của nó khi đến tay người sử dụng.  Đặc biệt yến đảo thô cao cấp được khai thác từ các hòn đảo ngoài biển khơi (trong hang đá, vách đá,…) – nơi có điều kiện môi trường sống khá khắc nghiệt nhưng đồng thời cũng nhờ vậy mà các tổ yến đảo thô nguyên tổ 20g được nuôi khá chắc chắn, to, dày và có chứa nhiều hàm lượng chất dinh dưỡng tốt hơn so với các loại yến nuôi nhà thông thường. Yến đảo thô nguyên tổ 20g tại Nest Vui được thu hoạch tại các vùng đảo trải dài từ Ninh Thuận đến Khánh Hoà. Đây là các khu vực có môi trường khí hậu phù hợp để chim yến sinh sống và phát triển mạnh nhất cho ra những tổ yến chất lượng nhất đến người dùng. Yến sào thô thiên nhiên thượng hạng 20g là tổ yến sở hữu đa dạng các thành phần dinh dưỡng có ích cho cơ thể, sức khoẻ của con người như: protein, prolin, Aspartic acid, Cystein, Phenylalamine, Tyrosine, Acid Syalic, Glucosamine,….và còn nhiều hàm chất dinh dưỡng có ích khác', 0, 0, 0, 20, 760000, N'hop-yen-dao-tho-nguyen-chat.jpg', N'10/9/22 1:27 PM', NULL, 4, 20, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (9, N'Huyết Yến TINH CHẾ Cao Cấp 50g – Thượng Hạng', N'HYTC50', N'Khai thác từ đảo thiên nhiên 100% – Địa hình hiểm trở Huyết yến được tinh chế làm sạch lông và tạp chất 100% với quy trình chuẩn ISO. Giữ nguyên vị yến và hàm lượng dinh dưỡng đến 99%. Quy cách đóng gói hộp 50g yến tinh chế.', N'Huyết yến tinh chế 50g giàu nguyên tố đa – vi lượng, khoáng chất tốt cho sức khỏe người dùng, huyết yến được xem là thực phẩm vàng giúp bổ sung sức khỏe cho người già, người vừa khỏi bệnh, phụ nữ mang thai,… thậm chí người đang giảm cân cũng có thể sử dụng.  Với quy trình làm sạch chuyên nghiệp, cam kết không sử dụng hóa chất tẩy rửa, đảm bảo giữ nguyên giá trị dinh dưỡng của sợi yến. Đặc biệt, khi mua huyết yến tinh chế 50g tại Nest Vui bạn còn được tặng kèm nhiều phần quà trị giá lên đến 250K và được cam kết HOÀN 200% nếu phát hiện yến kém chất lượng, làm giả hay độn nháy. . Giá huyết yến tinh chế 50g thượng hạng 3,5 triệu đồng – Đây là loại tổ yến sào đắt đỏ nhất trên thị trường hiện nay bởi nhiều lý do như sau:  Tổ yến huyết trước khi được tinh chế thành phẩm đã trải qua giai đoạn khai thác đầy nguy hiểm người người làm nghề yến, bởi huyết yến chỉ có tại các hang động, mõm đá có địa hình hiểm trở, khó khai thác. Tổ yến huyết thô 50g được các chim yến có sức đề kháng cao, kích thước lớn làm nên vì thế loại tổ yến này có hàm lượng dinh dưỡng cao nhất, cao hơn cả yến cam và yến trắng. Số lượng huyết yến thật khá ít trên thị trường, chỉ có tại các địa hình vách núi hiểm trỡ khó khai thác và khoáng chất có trong yến huyết nguyên chất rất cao nên đây được cho là 3 yếu tố quyết định giá tổ yến huyết cao nhất trên thị trường.', 0, 0, 0, 50, 3500000, N'hop-huyet-yen-tinh-che.jpg', N'10/9/22 1:29 PM', NULL, 7, 30, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (10, N'Yến Tinh Chế Loại 2 (Hộp 100g) – Gỗ', N'YTC2GO', N'Yến tinh chế loại 2 tại Nest Vui được làm sạch thủ công Tổ yến vẫn giữ được hình dạng nguyên tổ sợi phồng. Xuất xứ từ nhà yến Nest Vui với trọng lượng 8-10g/tổ Quy cách đóng gói hộp 100g tinh chế gồm 14-16 tai yến Tiện dụng để sử dụng ngay, tiết kiệm thời gian sơ chế.', N'Nhờ sỡ hữu hàm lượng chất dinh dưỡng cao mà yến làm sạch loại 2 có tác dụng rất lớn trong việc cải thiện tình trạng sức khoẻ người dùng, tuy nhiên tuỳ vào từng đối tượng sử dụng mà khả năng phát huy các chất dinh dưỡng có các tác dụng khác nhau, nhưng chung quy vẫn mang lại các tác dụng chính sau đây:  Nâng cao sức đề kháng, thể chất và cải thiện hệ miễn dịch. Khả năng phục hồi sức khoẻ sau bệnh hoặc sau sinh cao. Kích thích hệ tiêu hoá, tạo cảm giác muốn ăn. Tăng cường trí nhớ, phát triển não bộ. Làm giảm căng thẳng, mệt mỏi, stress hiệu quả. Để làm nên một chén yến thơm ngon bổ dưỡng vô cùng đơn giản, trước tiên bạn cần phải ngâm yến làm sạch loại 2 trong nước lạnh khoảng 30-45 phút, sau đó rửa sạch nhẹ nhàng tránh làm nát yến và để ráo trong khoảng 10 phút.  Tiếp đến, cần phải cho yến đã ráo vào chén rồi đổ nước sôi để nguội ngập yến. Đem chén yến đi chưng cách thuỷ với lửa nhỏ trong khoảng 20 phút, trước khi tắt bếp bỏ vào một ít đường phèn để yến trở nên ngon ngọt hơn. Liều lương sử dụng yến làm sạch loại 2 thích hợp Tuỳ vào từng đối tượng khác nhau mà có liệu lượng sử dụng yến làm sạch loại 2 100g khác nhau, cụ thể:  Trẻ nhỏ từ 1 – 3 tuổi: dùng 1 – 1.5g yến/lần, 3 lần/tuần. Trẻ nhỏ từ 3 – 10 tuổi: dùng từ 1.5 – 2g yến/lần, khoảng 4 lần/tuần. Người lớn: dùng 2 – 3g yến/lần, 4 lần/tuần. Người bệnh: 5g yến/lần, nên chia nhỏ ra ăn nhiều lần.', 0, 0, 0, 100, 4100000, N'hop-to-yen-nha-tinh-che-100g-loai-2.jpg', N'10/9/22 1:31 PM', NULL, 2, 10, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (11, N'Yến Huyết THÔ Cao Cấp 100g', N'TYT100', N'Khai thác từ đảo thiên nhiên 100% – Trọng lượng: 100g Tổ yến huyết thô còn nguyên tổ và lông, đảm bảo giữ nguyên giá trị dinh dưỡng Tổ yến huyết thô cao cấp 100g vẫn có vị tanh nhẹ đặc trưng của yến. Sản phẩm đã trải qua quá trình sấy khô trước khi đóng gói.', N'Yến huyết thô cao cấp 100g là loại yến đỏ cao cấp khan hiếm trên thị trường, ra đời nhờ vào phản ứng hoá học giữa các bức tường trong hang động và sự hấp thụ của các chất khoáng tự nhiên. Tổ yến huyết thô cao cấp 100g được xây dựng vô cùng chắc chắc và có chứa hàm lượng chất dinh dưỡng cực cao, đặc biệt tổ yến chỉ xuất hiện trên các hang đá ngoài đảo.  Vì nằm trong dòng tổ yến cao cấp, khan hiếm trên thị trường nên giá thành của tổ yến huyết thô cao cấp 100g không hề thấp, tuy nhiên đổi lại những dưỡng chất mà tổ yến đem lại giúp bạn bồi bổ cơ thể khoẻ mạnh tốt nhất. Xem ngay bài viết dưới đây để biết chi tiết hơn về yến sào huyết thô nhé! Yến huyết thô là gì? Yến huyết thô cao cấp 100g là những tổ yến có màu đỏ cam được khai thác ra từ những hang đá sâu, nơi đây có địa chất phong phú kết hợp với sự khoáng chất giàu vốn có của môi trường từ đó mới hình thành nên loại tổ yến khán hiếm này.  Những tổ yến huyết thô cao cấp 100g có chứa hàm lượng chất dinh dưỡng bổ ích cho cơ thể (như sắt, magan) nhiều hơn so với các tổ yến trắng, yến hồng thông thường. Yến huyết thô cao cấp 100g tại Nest Vui đem đến cho khách hàng là những tổ yến được khai thác nguyên chất chưa trải qua bất kì quá trình sơ chế làm sạch nào, vẫn còn nguyên vẹn các tạp chất, bụi bản và lông chim, mang theo một mùi tanh nhẹ của yến.  Vì là tổ yến thô nguyên chất nên vẫn giữ được trọn vẹn hàm lượng các chất dinh dưỡng vốn có. Trong đó, yến huyết thô cao cấp 100g có chứa nhiều axit amin quan trọng, glycol, protein và một số hàm lượng có ích khác như Aspartic acid, Serine, Tyrosine, Phenylanine, Valine, Aginine, Leucine.', 0, 0, 0, 100, 4600000, N'hop-yen-huyet-tho-100g.jpg', N'10/9/22 1:33 PM', NULL, 4, 100, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (12, N'Chân Yến THÔ Loại 1 20g', N'CYT20', N'Chân yến thô loại 1 20g – Nguyên Chất 100%, GIÁ RẺ Khai thác tại các nhà yến có trên 10 năm tuổi (Ninh Thuận – Khánh Hoà) Xuất xứ từ nhà phân phối yến NEST VUI chất lượng – uy tín Tặng kèm nhiều quà tặng chất lượng, giá trị dinh dưỡng cao Tiện dụng để sử dụng ngày, tiết kiệm thời gian sơ chế.', N'Chân yến thô loại 1 20g được nhiều người dùng sành yến biết đến với ưu điểm sở hữu nhiều hàm lượng chất dinh dưỡng bổ ích cho sức khoẻ của người sử dụng. Đặc biệt tại Việt Nam, tổ yến xào thường xuyên xuất hiện và được xem như là thực phẩm chức năng được sử dụng thân thuộc khi có thể làm quà tặng, làm thức ăn bồi bổ sau khi ốm đau,… Chân yến thô loại 1 được khai thác ở đâu? Chân yến thô loại 1 20g tại Nest Vui được khai thác trực tiếp tại các nhà nuôi yến có trên 10 năm tuổi, trải dài từ Ninh Thuận cho đến Khánh Hoà – những địa điểm cung ứng yến có tiếng nhất tại thị trường yến Việt Nam hiện nay, mang đến cho người dùng trải nghiệm với những tổ yến/ chân yến chất lượng, giàu chất dinh dưỡng tốt nhất.  Đặc điểm nhận dạng chân yến thô loại 1 Vì là phần yến được xây dựng đầu tiên với nhiều lớp bọt yến chồng chéo lên nhau nên có thể dễ dàng nhận biết chân yến thô loại 1 20g thông qua hình dạng cục khá cứng, thịt nhiều và có mùi tanh đặc trưng nồng hơn so với phần thân của yến.  Ngoài ra, các sợi yến khá ngắn vì chân yến được bám khá chắc trong thanh xây yến nên trong quá trình khai thác không tránh khỏi việc gãy ra thành những đoạn nhỏ. Đặc biệt, sau giai đoạn chế biến yến khi ăn sẽ cảm nhận được mùi thơm, sợi yến dai giòn, khi nhai sẽ có độ sừn sựt. Nhờ sở hữu nhiều hàm lượng thành phần chất dinh dưỡng như protein, 18 loại axit amin và 31 nguyên to vi lượng cần thiết cho người già và trẻ em nên chân yến thô loại 1 20g mang đến công dụng vô cùng bổ ích cho sức khoẻ của người dùng', 0, 0, 0, 20, 740000, N'chan-yen-nha-tho-20g.jpg', N'10/9/22 1:35 PM', NULL, 5, 20, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (13, N'Chân Yến TINH CHẾ Loại 1 50g', N'CYTC150', N'Chân yến tinh chế loại 1 50g Nest Vui được làm sạch thủ công với quy trình, công nghệ chuyên nghiệp. Chân yến khai thác từ nhà yến Ninh Thuận, Khánh Hòa Chân yến giòn dai, tinh chế giữ nguyên vị yến Quy cách đóng gói: hộp 50g được tinh chế sạch 100%. Tiện dụng để sử dụng ngày, tiết kiệm thời gian sơ chế.', N'Chân yến sào tinh chế loại 1 50g tại Nest Vui được tinh chế làm sạch theo tiêu chuẩn an toàn về sinh thực phẩm và được kiểm định chất lượng trước khi đến tay khách hàng, đảm bảo sử dụng chất phụ gia trong quá trình tinh chế yến.  Áp dụng công nghệ sấy tiên tiến đảm bảo giữ nguyên hàm lượng dinh dưỡng trong chân yến, ngoài ra khi đóng gói hộp yến cũng được khử khuẩn qua đèn tím nhằm loại bỏ hoàn toàn vi khuẩn gây hại. Chân Yến Tinh Chế Loại 1 50g Khai Thác Ở Đâu? Chân yến sào tinh chế loại 1 50g được tạo ra từ chân yến thô loại 1 được khai thác tại hệ thống nhà yến trải dài từ Ninh Thuận đến Khánh Hòa, đây là 2 vùng có sản lượng yến với tỷ lệ đạm cao nhất (đạt đến 62.5%).  Đặc biệt, Chân yến sào tinh chế loại 1 được chọn lọc ra những chân yến dày, to và được khai thác từ các nhà yến gần biển đảo có hơn 10 năm tuổi, mang lại hàm lượng dinh dưỡng dồi dào. Mua Chân Yến Sào Tinh Chế 50g Nest Vui gồm những gì? Chân yến sào tinh chế 50g giá chỉ 2.150.000đ tại Nest Vui, bên cạnh đó bạn còn được tặng kèm nhiều phần quà chất lượng như:  Tặng 50g táo đỏ Organic nhập khẩu Hàn Quốc, giàu chất xơ, ngọt thanh nhẹ, tốt cho sức khỏe. 50g Đường phèn kết tinh tự nhiên, không qua tẩy trắng, cực kỳ an toàn cho sức khỏe. Ngoài ra, nếu mua 1 lạng chân yến tinh chế loại 1 bạn còn được tặng thêm 1 Thố chưng yến Minh Long với dung tích 330ml được nung nấu ở nhiệt độ cao, cam kết không chì, cadimi bởi hãng.', 0, 0, 0, 50, 2150000, N'chan-yen-tinh-che-loai-1-50g.jpg', N'10/9/22 1:37 PM', NULL, 5, 50, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (14, N'Yến Thô Đá (Đảo) Loại Thượng Hạng 100g', N'YTD100', N'Yến thô khai thác tự nhiên tại vách núi, hang động tại Ninh Thuận, Khánh Hòa. Tổ yến thô tự nhiên loại đặc biệt được chọn lọc theo tiêu chuẩn khắt khe. Tổ yến dày và nhiều sợi và ít lông hơn hơn so với loại 2 và yến thô nhà nuôi loại 1. Quy cách 10 – 12 tai yến thô nguyên tổ loại đặc biệt Quy cách: hộp 100g – TẶNG KÈM: Nhiều sản phẩm chất lượng.', N'Tổ yến thô loại đặc biệt tại Nest Vui là loại yến đá tự nhiên với tai yến to, sợi dài, bùng yến dày,… tổ yến thô thiên nhiên loại 1 đặc biệt được chọn lọc với những tai yến có kích thước lớn còn chân yến được tìm thấy tại các vách núi, hang động hiểm trở. Chúng có hàm lượng dinh dưỡng cao và sợi yến dai thơm nồng vị yến.  Yến sào thiên nhiên thô loại đặc biệt hoàn toàn chưa qua xử lý nên có hàm lượng dinh dưỡng nguyên chất 100%  rất thích hợp cho những ai muốn tự tay chế biến tổ yến sào để đảm bảo chất lượng. Tìm Hiểu Yến Thô Loại Đặc Biệt – Yến Sào Thiên Nhiên Yến thô loại đặc biệt thuộc dòng yến sào thiên nhiên chưa qua xử lý và được chọn lọc kỹ càng để lấy ra những tổ có tiêu chuẩn tốt nhất với kích thước tai yến to, bụng dày và còn nguyên chân yến, thường tổ yến thô thiên nhiên loại 1 có trọng lượng khoảng 10g.  Vì khai thác trong hang động, vách núi hiểm trỡ nên tổ yến thường không nguyên vẹn nên việc chọn ra một tổ yến sào thô loại đặc biệt 100g rất ít.  1. Khai thác tổ yến thô loại đặc biệt ở đâu? Tổ Yến thô loại đặc biệt 100G tại Nest Vui được khai thác chủ yếu tại hang động, vách núi tại Khánh Hòa, Ninh Thuận,… Vì chim yến ở các vùng biển này có kích thước khá lớn, sức để kháng cao vì sống trong môi trường khắc nghiệt nên hàm lượng dinh dưỡng có trong tổ yến sào thô thiên nhiên RẤT CAO hơn hẵn các loại yến nhà thô loại 1 100g.  2. Tổ yến sào thô loại 1 phải đáp ứng yêu cầu nào? Để được xếp vào loại đặc biệt, tổ yến trên vách đá phải đáp ứng yêu cầu về kích thước to, độ dày đều nhau, hình dáng võng tròn, ít lông và tạp chất để người dùng tiết kiệm 30% thời gian sơ chế yến sào thô.  Vì ít tạp chất nên so với các loại tổ yến thông thường, yến thô thiên nhiên loại đặc biệt 100g ít bị hao hụt trọng lượng hơn khi sạch đến 20% so với yến loại 2.', 0, 0, 0, 100, 3800000, N'hop-yen-dao-tho-100g.jpg', N'10/9/22 1:40 PM', NULL, 8, 10, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (15, N'Yến Huyết THÔ Cao Cấp 50g', N'YHT50', N'Tổ yến huyết thô cao cấp NEST VUI – Trọng lượng 50g Khai thác trực tiếp từ đảo thiên nhiên 100% (Ninh Thuận – Khánh Hoà) Tổ yến huyết thô còn nguyên tổ và lông, có vị tanh nhẹ đặc trưng c Tặng kèm nhiều quà tặng chất lượng, giá trị dinh dưỡng cao', N'Tổ yến huyết thô cao cấp 50g là loại thực phẩm chức năng có chứa nhiều hàm lượng chất dinh dưỡng cao có ích bồi bổ sức khoẻ cho người sử dụng được BÁN CHẠY NHẤT tại Nest Vui. Đây cũng là loại tổ yến khan hiếm trên thị trường chỉ chiếm 20% so với tổng sản lượng yến nói chung được bán trên thị trường. Những điều cần biết về yến huyết thô cao cấp 50g Yến huyết thô được khai thác ở đâu? Tổ yến huyết thô cao cấp 50g tại Nest Vui được khai thác trực tiếp tại các hang đá sâu ngoài các vùng đảo nuôi yến tự nhiên, các đảo này nằm trong địa phận thuộc vùng biển từ Ninh thuận đến Khánh Hoà. Có thể nói đảo là nơi có môi trường sống khắc nghiệt, nhưng cũng là nơi có giàu khoáng chất bổ ích góp phần tạo nên những tổ yến huyết thô cao cấp 50g khan hiếm với giá trị chất dinh dưỡng cực cao.  Đặc điểm của tổ yến huyết thô cao cấp 50g Như đã giới thiệu tổ yến huyết thô cao cấp 50g là những tổ yến khan hiếm được hình thành thông qua phản ứng hoá học của các bức tường hang đá với sự hấp thụ của các khoáng chất có trong môi trường, chính vì vậy mà giá trị hàm lượng dinh dưỡng có trong tổ yến huyết cao hơn so với các tổ yến trắng, yến hồng thông thường.  Đặc biệt vì là loại yến huyết thô cao cấp 50g chưa trải qua bất kì quy trình sơ chế làm sạch nào, vẫn còn bám dính lông chim, bụi bẩn và các tạp chất khác nên giá trị dinh dưỡng được giữ hoàn toàn nguyên vẹn như vốn có của nó. Thông thường, bạn sẽ dễ dàng nhận biết các tổ yến huyết thô cao cấp 50g qua các đặc điểm như yến màu đỏ cam, tổ to, dày bụng, sợi nhiều, ít lông. Thông qua phân tích của các nhà nghiên cứu cho biết trong tổ yến huyết thô cao cấp 50g có chứa 31 loại vi chất là 18 loại axit amin và glycol, protein. Ngoài ra, còn chứa một số thành phần khác như Aspartic acid, Serine, Tyrosine, Phenylanine, Valine, Aginine, Leucine.', 0, 0, 0, 50, 2300000, N'hop-yen-huyet-tho-50g.jpg', N'10/9/22 1:42 PM', NULL, 7, 20, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (16, N'Chân Yến Đá (Đảo) Tinh Chế Thượng Hạng 100g', N'CY100D', N'Chân yến đảo tinh chế thượng hạng Nest Vui được làm sạch thủ công với quy trình, công nghệ chuyên nghiệp. Chân yến tự nhiên giòn dai, giữ nguyên vị yến Quy cách đóng gói hộp 100g chân tổ yến tinh chế sạch 100%. Tiện dụng để sử dụng ngày, tiết kiệm thời gian sơ chế.', N'Chân yến đá (đảo) thiên nhiên là phần chân của tổ yến tự nhiên được chim yến làm đầu tiên với nhiều sợi bện chặt nhau nên có thành dày, nó cũng là phần già nhất  của tổ yến có độ dai giòn và chứa nhiều dinh dưỡng nhất.  Chân yến đảo được khai thác tại các vách đá tự nhiên, trong đó chân yến đảo tinh chế thượng hạng 100gr được làm sạch lông và tạp chất 100% và cam kết KHÔNG can thiệp hóa chất làm sạch độc hại tại Nest Vui. Chân yến đảo tinh chế thượng hạng 100g được làm sạch với quy trình đảm bảo an toàn thực phẩm, ứng dụng các công nghệ tiên tiến cho ra các sản phẩm yến chất lượn, giữ nguyên hàm lượng dinh dưỡng có trong tổ yến nguyên chất.  Chân yến sào đảo tự nhiên sau khi được tinh chế sẽ sấy khô và chiếu đèn tím khử trùng khii đóng hộp để loại bỏ hoàn toàn các vi khuẩn gây hại bên ngoài bao bì sản phẩm, hoàn toàn đủ tiêu chuẩn để xuất khẩu. Hàm lượng đạm có trong chân yến đảo tinh chế sấp sỉ với lượng đạm yến đảo tinh chế thượng hạng 100g là 58%. Chân yến đá thiên nhiên thơm nồng vị yến bởi đây là bộ phận được chim yến chú trọng xây dựng vững chắc nhất. Chân yến có kích thước nhỏ nhưng đây là bộ phận chứa nhiều hàm lượng dinh dưỡng nhất. Do chân yến có cấu tạo dày đặc nên khi ăn sẽ cảm giác dai giòn, đặc biệt các tổ yến đủ tuổi. Sản phẩm chân yến đảo tinh chế thượng hạng được đóng gói với nhiều quy cách như: 20g, 50g và 100g.', 0, 0, 0, 100, 4900000, N'chan-yen-dao-tinh-che-100g-1.jpg', N'10/9/22 1:44 PM', NULL, 8, 50, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (17, N'Huyết Yến TINH CHẾ Cao Cấp 100g – Thượng Hạng', N'HY10011', N'Khai thác từ đảo thiên nhiên 100% – Địa hình hiểm trở Huyết yến được tinh chế làm sạch lông và tạp chất 100% với quy trình chuẩn ISO. Giữ nguyên vị yến và hàm lượng dinh dưỡng đến 99%. Quy cách đóng gói hộp 100g yến tinh chế.', N'Huyết yến cao cấp được xem là tuyệt phẩm với hàm lượng dinh dưỡng cực cao, chúng được tìm thấy tại các mỏm đá sâu, giàu khoáng chất, cheo leo, hiểm trở,… Loại tổ yến này chỉ khai thác được trong tự nhiên và rất hiếm gặp, do đó số lượng khá ít và giá tổ yến huyết cũng vô cùng đắc đỏ trên thị trường.  Huyết yến tinh chế 100g được được tinh chế làm sạch lông và tạp chất hoàn toàn với công nghệ hiện đại và được rút lông thủ công đảm bảo hàm lượng dinh dưỡng được giữ nguyên. Yến Huyết Tinh Chế 100g Có Gì Nổi Bật? Yến huyết tinh chế 100g chứa nhiều nguyên tố đa – vi lượng, giàu Axit Amin quý hiếm giúp nâng cao sức khỏe, thể lực, đặc biệt rất thích hợp dùng làm thực phẩm bồi bổ sức khỏe cho người già và người mới khỏi bệnh.  Huyết yến tinh chế 100g có rất ít trong tự nhiên nhưng lại có hàm lượng dinh dưỡng cao, do vậy giá yến huyết tinh chế rất cao từ 6,9 triệu/100g trên thị trường và không được sử dụng phổ biến như bạch yến. Thông Tin Yến Huyết Tinh Chế 100g Yến huyết tinh chế cao cấp 100g được làm sạch thủ công đảm bảo an toàn thực phẩm chuẩn ISO, hoàn toàn có cơ hội xuất khẩu sang các thị trường châu Âu. Cùng tham khảo một số thông tin về tổ yến huyết tinh chế 100g Nest Vui ngay nhé! Rất nên mua huyết yến tinh chế cao cấp 100g, bởi chúng mang đến nhiều đặc điểm nổi bật như:  Huyết yến tinh chế 100g thuộc TOP thực phẩm giàu giá trị dinh dưỡng, thích hợp cho mọi đối tượng sử dụng, giúp bồi bổ sức khỏe nhưng không tăng cân. Tổ yến huyết tinh chế cao cấp 100g được làm sạch tạp chất, lông theo quy trình an toàn thực phẩm chuẩn ISO, đảm bào giữ nguyên giá trị dinh dưỡng đến 98-99%. Để có 100g huyết yến tinh chế cao cấp Nest Vui đã chọn lọc kỹ lưỡng với những tai yến già, nguyên vẹn, trải qua công đoạn xử lý làm sạch tỉ mỹ, ngay cả khi đóng gói các bao bì cũng được chiếu đèn tím để loại bỏ hoàn toàn vi khuẩn gây hại. Ngoài ra, với màu sắc bắt mắt rất phù hợp làm qu', 0, 0, 0, 100, 6900000, N'hop-to-huyet-yen-tho-100g.jpg', N'10/9/22 1:46 PM', NULL, 4, 20, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (18, N'Yến Đá (Đảo) Tinh Chế Thương Hạng Loại 50g', N'YDD50G', N'Yến tinh chế loại 1 Nest Vui khai thác từ tự nhiên đã xử lý và làm sạch Tổ yến vẫn giữ được hình dạng nguyên tổ sợi phồng. Quy cách đóng gói hộp 50g tinh chế gồm 6 – 7 tai yến Tiện dụng để sử dụng ngày, tiết kiệm thời gian sơ chế.', N'Yến sào tinh chế loại 1 (hộp 50g) tại Nest Vui được khai thác trực tiếp trên đảo trong các hang đá hoặc vách đá lớn, có chứa hàm lượng chất dinh dưỡng cao hơn gấp nhiều lần so với các loại yến nhà thông thường, vì các tổ yến đảo này được tạo nên khá chắc chắn và chất lượng từ loài chim yến có sức sống mãnh liệt, chịu được sự khắc nghiệt của môi trường trên đảo. Yến sào tinh chế loại 1 là những tổ yến sau khi khai thác đã trải qua quy trình sơ chế làm sạch thủ công từ các nghệ nhân chuyên nghiệp giúp loại bỏ các lông chim, bụi bẩn hay các tạp chất khác bám dính trên yến, đem lại tổ yến sào tinh chế loại 1 trắng sạch, đảm bảo an toàn vệ sinh thực phẩm tốt nhất.  Để nhận biết đâu là yến sáo tinh chế loại 1 thật sự không khó. Bạn chỉ cần quan sát chú ý các đặc điểm bên ngoài yến là rất dễ nhận ra, cụ thể:  Màu sắc	Trắng đục Kích thước	Tai yến to, phần bụng dày Mùi vị	Thơm vị yến, một chút vị tanh Sợi yến	Dài Yến sào tinh chế loại 1 có tốt không? Như đã giới thiệu qua ở trên, yến sào tinh chế loại 1 tại Nest Vui được khai thác hoàn toàn tự nhiên trong các hang đá, vách đá trên đảo nên các tổ yến tại đây có chứa hàm lượng dinh dưỡng vô cùng cao có tác dụng rất lớn đến sức khoẻ cửa người dùng ở mọi lứa tuổi, cụ thể như:  Kích thích hệ tiêu hoá, giúp người dùng ăn uống ngon hơn. Tăng cường trí nhớ, phát triển não bộ hiệu quả. Hỗ trợ phục hồi sức khoẻ nhanh chóng sau bệnh. Nâng cao sức đề kháng, tăng cường thể lực. Bảo vệ xương khớp hiệu quả, hạn chế tình trạng đau mỏi Làm giảm ho, giúp bổ phế.', 0, 0, 0, 50, 2600000, N'to-yen-sao-thien-nhiien-tinh-che-50g.jpg', N'10/9/22 1:48 PM', NULL, 3, 432, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (19, N'Yến Đảo (Đá) Tinh Chế Thượng Hạng 20g', N'YDTC20G', N'Yến Đảo (Đá) Tinh Chế Thượng Hạng 20g', N'Yến đảo tinh chế 20g là những tổ yến được khai thác từ các vách đá, hang đá trên các hòn đảo ngoài khơi xa bờ sau đó trải qua quá trình sơ chế, đóng gói cẩn thận mới tạo thành tổ yến đảo tinh chế hoàn chỉnh đem đến tay khách hàng. Chính vì vậy mà giá thành của dòng yến đảo tinh chế thượng hạng 20g chưa bao giờ là rẻ.  Như đã biết, đảo có môi trường sống khá khắc nghiệt nên những chú chim yến sinh sống tại các khu vực này có sức sống khá mãnh liệt và có sức đề kháng cực cao, vì vậy nên những tổ yến thô mà chim yến tạo ra không những chắc chắn, to – dày mà giá trị dinh dưỡng của chúng cực lớn. Cho nên có thể hiểu được tại sao yến đảo tinh chế 20g rất được ưa chuộng tại Nest Vui. Yến đảo tinh chế thượng hạng có tốt không? Câu trả lời chắc chắn là có. Yến đảo tinh chế 20g hấp thụ được nhiều khoáng chất dinh dưỡng đặc biệt chỉ có ở loại yến đảo rất tốt cho cơ thể và sức khoẻ của người sử dụng. Cụ thể như sau:  Có tác dụng làm sạch phổi và các cơ quan hô hấp Tăng cường hệ miễn dịch, nâng cao sức đề kháng, thể lực Tăng cường trí nhớ, phản xạ thần kinh, phát triển não bộ Hồi phục sức khoẻ nhanh chóng sau khi bệnh hoặc sau khi sinh Chăm sóc da căng mịn, chống lão hoá, tăng tuổi thọ Kích thích ăn uống, mang đến giấc ngủ sâu Làm giảm căng thẳng, mệt mỏi, lo lắng,… Nguồn gốc của yến đảo tinh chế 20g Tại Nest Vui, yến đảo thiên nhiên tinh chế được khai thác hoàn toàn tự nhiên, trực tiếp trên các hòn đảo xa bờ trải dài từ Ninh Thuận đến Khánh Hoà. Được biết, tại những tỉnh thành này, loài chim yến sinh sôi khá nảy nỡ, do hợp với khí hậu cũng như thích nghi được môi trường sống khắc nghiệt nên cho ra những tổ yến vô cùng chất lượng, chứa nhiều hàm lượng chất dinh dưỡng tốt cho sức khoẻ con người.  Đặc điểm của yến đảo tinh chế Yến đảo tinh chế 20g thượng hạng là một trong những tổ yến cao cấp tại Nest Vui, đã được trải qua quy trình xử lý, làm sạch lông chim, bụi bẩn hay các tạp chất khác bám trên yến thông qua phương pháp hoàn toàn thủ công chuyên nghiệp, không sử dụng đến bất kì phương pháp hoá chất nào gây hại cho người dùng.', 0, 0, 0, 20, 1090000, N'yen-dao-tinh-che-20g-thuong-hang.jpg', N'10/9/22 1:50 PM', NULL, 2, 20, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (20, N'Yến Sào Thô Loại 1 (Hộp 100g)', N'YSTT1', N'Tổ yến thô còn nguyên tổ và lông chim yến, lồi lõm không đều. Tổ yến sào thô loại 1 hộp 100g có vị yến tanh nhẹ đặc trưng. Sản phẩm trải qua quy trình sấy khô trước khi đóng gói. Một hộp 100g yến thô sẽ có khoảng 10 – 12 tổ yến.', N'Tổ Yến Thô Loại 1 – Khai Thác Nhà Yến Hơn 10 Năm Tuổi Tổ yến thô loại 1 là loại tổ yến nguyên chất được thu hoạch tại nhà yến chưa trải qua bất kỳ quá trình xử lý nào nên còn lông, bụi bẩn và các tạp chất khác, đồng thời chúng đảm bảo còn 100% giá trị dinh dưỡng vốn có.  Với các nhà yến có tuổi thọ càng cao thì giá trị giá trị dinh dưỡng càng cao, tuy nhiên cũng tùy thuộc vào khu vực, nguồn thức ăn của chim yến mà hàm lượng dinh dưỡng trong tổ yến khác nhau.  Đối với tổ yến thô loại 1 100g tại Nest Vui được thu hoạch tại hệ thống hơn 15 nhà yến trải rộng từ Ninh Thuận đến Khánh Hòa – Đây được cho là 2 vùng khai thác tổ yến sào nổi tiếng nhất toàn cầu với giá trị dinh dưỡng có trong yến cực cao. Độ nở của yến thô loại 1 gấp 4-5 lần khi ngâm Yến thô loại 1 hộp 100g của Nest Vui có thể nở gấp 4-5 lần khi ngâm, bạn có thể sơ chế yến thô và bảo quản yến tươi trong ngăn mát để dùng dần. Vì 1 tai yến thô loại 1 khi ngâm có thể chưng được 10 lọ yến 30ml, do vậy cũng rất tiết kiệm để sử dụng.  Sợi yến nhà thô thơm nhẹ, ít tanh hơn yến đảo Khi chế biến thành món ăn sợi yến thô loại 1 có mùi thơm nhẹ, khá dài và giòn. Do vậy yến thô nhà nuôi loại 1 thường được ưa chuộng bởi tính dễ ăn mà giá thành lại rẻ.  Mặc dù, quá trình sơ chế rất mất thời gian, nhưng đối với những người sành ăn thường thích tổ yến thô loại 1 hơn bởi họ sẽ thấy an tâm hơn khi chính tay mình sơ chế và hiểu rõ tổ yến đã được làm sạch như thế nào.', 0, 0, 0, 100, 3200000, N'yen-tho-nguyen-to-100g-loai-1.jpg', N'10/9/22 1:52 PM', NULL, 1, 30, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (21, N'TỔ YẾN LÀM SẠCH 50G – TIÊU CHUẨN THƯỜNG', N'TYLS50T', N'Tổ yến thô đã được xử lý sạch, sợi phồng, trắng, có độ bóng ánh kim. ❖ Tỉ lệ sợi gãy/đứt và sợi nguyên: 50%-50% bề mặt, phần bụng sợi vụn. ❖ Quy cách 6 miếng/hộp (1 miếng chưng #3 chén, khẩu phần cho #18 chén) ❖ Dùng ngày 1 chén – cách ngày – khẩu phần ăn cho hơn 1 tháng. ❖ Tiện lợi để sử dụng ngay, tiết kiệm thời gian và lượng hao hụt trong quá trình xử lý. ❖ Được hỗ trợ chi phí gia công từ Thượng Yến. ❖ Tặng kèm 1 hộp đường phèn + 1 hộp sen Huế đặc sản/táo đỏ Hàn Quốc+ 1 Thượng Yến VIP CARD. ❖ Tặng kèm thố sứ chưng yến “Thạo Bếp” trị giá 100.000đ', N'Đặc điểm của tổ yến làm sạch/ Yến sào tinh chế Tổ yến được thu hoạch từ hệ thống nhà dẫn dụ yến chuyên nghiệp. Sau đó được tuyển chọn, ngâm nước cho nở đều. Rồi được những người thợ yến dùng nhíp gắp sạch lông bám trong tổ yến và đưa vô máy sấy lạnh.  Tổ yến đã được xử lý sạch, sợi phồng, trắng, có độ bóng ánh kim, hình cánh sen đẹp mắt. Đảm bảo không làm tổ yến bị mất màu và chất dinh dưỡng. Tiện lợi để sử dụng ngay, tiết kiệm thời gian và lượng hao hụt trong quá trình xử lý. Giá thành thấp hơn so với yến sơ chế. Tổ yến làm sạch tiêu chuẩn thường: Tỉ lệ sợi gãy/đứt và sợi nguyên: 50%-50% bề mặt, phần bụng sợi vụn.  Có thể bạn quan tâm: Tổ yến làm sạch tiêu chuẩn cao cấp 50g. Quy trình xử lý tổ yến làm sạch/ Yến sào tinh chế. 6 ưu điểm khi mua yến sào Thượng Yến 100% tổ yến nguyên chất khai thác tại nhà yến chuyên nghiệp. Chọn lọc kỹ lưỡng. Điểm 10 cho chất lượng. Xử lý bởi những nghệ nhân yến sào yêu nghề, giàu kinh nghiệm. Không sử dụng chất bảo quản, tẩm ướp, phụ gia. Cam kết bồi hoàn gấp 10 lần nếu phát hiện hàng giả, kém chất lượng. Đóng gói sang trọng, xứng tầm “thượng phẩm”. Những ai nên sử dụng tổ yến? Yến sào Thượng Yến thích hợp sử dụng bồi bổ cho mọi đối tượng. Đặc biệt là trẻ em, người cao tuổi, phụ nữ mang thai, người đang điều trị bệnh,… Có thể bạn quan tâm: Tổ yến làm sạch tiêu chuẩn thường 100g.', 0, 0, 0, 50, 2590000, N'ThuongYen-ToYenSachLong-Thuong50gr-02-600x600.jpg', N'10/27/22 7:40 AM', NULL, 2, 10, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (22, N'TỔ YẾN LÀM SẠCH 50G – TIÊU CHUẨN CAO CẤP', N'TYLS50CC', N'❖ Tổ yến thô đã được xử lý sạch, sợi phồng, trắng, có độ bóng ánh kim. ❖ Tỉ lệ sợi gãy/đứt và sợi nguyên: 20%-80% bề mặt, phần bụng sợi vụn. ❖ Quy cách 6 miếng/hộp (1 miếng chưng #3 chén, khẩu phần cho #18 chén/hộp) ❖ Dùng ngày 1 chén – cách ngày – khẩu phần ăn cho 1 tháng. ❖ Tiện lợi để sử dụng ngay, tiết kiệm thời gian và lượng hao hụt trong quá trình xử lý.', N'Đặc điểm của tổ yến làm sạch/ Yến sào tinh chế Yến sào tính chế được thu hoạch từ hệ thống nhà dẫn dụ yến chuyên nghiệp. Sau đó được tuyển chọn, ngâm nước cho nở đều. Rồi được những người thợ yến dùng nhíp gắp sạch lông bám trong tổ yến và đưa vô máy sấy lạnh.  Tổ yến đã được xử lý sạch, sợi phồng, trắng, có độ bóng ánh kim, hình cánh sen đẹp mắt. Đảm bảo không làm tổ yến bị mất màu và chất dinh dưỡng. Tiện lợi để sử dụng ngay, tiết kiệm thời gian và lượng hao hụt trong quá trình xử lý. Giá thành thấp hơn so với yến sơ chế. Tổ yến làm sạch tiêu chuẩn cao cấp: Tỉ lệ sợi gãy/đứt và sợi nguyên: 20%-80% bề mặt, phần bụng sợi vụn. 13 Công Dụng tuyệt đối không thể bỏ qua khi nhắc đến Yến Sào 1. Kích thích tiêu hóa, giúp ăn uống ngon miệng  Phân tích thành phần của tổ yến, các nhà dinh dưỡng phát hiện ra Cr và một số nguyên tố quý hiếm khác. Chúng có tác dụng tích cực trong việc thúc đẩy tiêu hóa, kích thích vị giác, tăng cường khả năng chuyển hóa cũng như hấp thụ các chất dinh dưỡng. Qua đó giúp người bệnh ăn uống ngon miệng và có một sức khỏe tốt hơn.  2. Bổ phế, long đờm, giảm ho  Đối với những người hay mắc bệnh đường hô hấp như viêm phổi, ho đàm, cảm cúm, hen suyễn thì tổ yến chính là phương thuốc chữa lành tuyệt vời. Thực phẩm này được sử dụng như một loại dược liệu trong Đông y với tác dụng dưỡng âm, bổ phế, giảm ho, làm sạch đàm nhầy ở đường hô hấp và ức chế phản ứng dị ứng gây viêm đường hô hấp.  Theo kinh nghiệm dân gian, tổ yến thường được đem chứng với gừng ăn 3 lân mỗi tuần. Món ăn bài thuốc này có tác dụng làm sạch phổi, cải thiện chức năng của hệ hô hấp.  3. An thần, bổ não, tăng cường trí nhớ  Đây là những công dụng tuyệt vời của yến đối với hệ thần kinh trung ương. Nghiên cứu cho thấy các vi chất dinh dưỡng trong tổ yến như Mn, Cu, Zn, Br có tác dụng an thần, xoa dịu căng thẳng thần kinh, giúp bộ não ghi nhớ và xử lý thông tin tốt hơn.  Ngoài ra, thực phẩm này còn hỗ trợ điều trị mất ngủ, giúp người bệnh ngủ ngon và sâu giấc hơn.  4. Tổ yến cải thiện hệ miễn dịch  Sỡ hữu 18 loại axit amin cùng nhiều vitamin và khoáng chất thiết yếu, ăn tổ yến thường xuyên sẽ giúp cải thiện hệ miễn dịch, nâng cao sức đề kháng. Nhờ vậy cơ thể chúng ta sẽ có sức chống đỡ tốt hơn khi bị các tác nhân gây bệnh tấn công.  5. Chống lão hóa, cải thiện cấu trúc da  Trong tổ yến chứa thành phần Threonine phong phú. Chất này tham gia vào quá trình sản xuất collagen và elastin thúc đẩy quá trình táo tạo các tế bào mới, làm tăng độ đàn hồi, cải thiện kết cấu da.  Đặc biệt, khi kết hợp với glycerin, nó sẽ giúp làm chận tiến trình lão hóa, làm sáng da, ngăn ngừa sự hình thành của các vết nám, tàn nhang và nếp nhăn trên da.  Với những công dụng tuyệt vời trên, tổ yến được phái đẹp rất ưa chuộng và sử dụng thường xuyên trong thực đơn để duy trì tuổi xuân.', 0, 0, 0, 50, 3290000, N'ThuongYen-ToYenSachLong-CaoCap50gr-01-600x600.jpg', N'10/27/22 7:42 AM', NULL, 5, 10, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (23, N'TỔ YẾN THƯỢNG HẠNG 50G – TIÊU CHUẨN THƯỜNG', N'TYTH50TC', N'❖ Là dòng sản phẩm cao cấp nhất từ Thượng Yến. ❖ Được xử lý bởi những người thợ có tay nghề cao. ❖ Đảm bảo yêu cầu khắt khe về độ tinh tuý, nguyên chất của tổ yến. ❖ Quy cách 6 miếng/hộp (1 miếng chưng #3 chén, khẩu phần cho #18 chén) ❖ Dùng ngày 1 chén – cách ngày – khẩu phần ăn cho hơn 1 tháng. ❖ Thích hợp để biếu tặng. ❖ Tặng kèm 1 hộp đường phèn + 1 hộp sen Huế đặc sản/táo đỏ Hàn Quốc+ 1 Thượng Yến VIP CARD.', N'Đặc điểm của yến sào Thượng Hạng (hay còn gọi là tổ yến cao cấp) Tổ yến cao cấp được thu hoạch từ hệ thống nhà dẫn dụ yến chuyên nghiệp và được Thượng Yến tuyển chọn rất khắt khe. Tiếp sau đó, tổ yến sẽ được làm mềm bằng công nghệ phun lạnh và được những người thợ có tay nghề cao nhất tỉ mỉ gắp từng chiếc lông.  Do hạn chế tối đa việc tiếp xúc với nhiều nước, ít thông qua đúc khuôn phục dựng, yến sào gần như giữ được hình dạng ban sơ của tổ yến, sạch lông, màu trắng ngà.  Yến sào Thượng Hạng tiêu chuẩn thường:  Tổ yến ít bụng, hình dạng tròn đều, có 2 mặt sợi, liên kết bề mặt sợi có khe hở. Tỉ lệ nguyên vẹn hình dáng ban sơ 50%, tỉ lệ hao hụt ~10%. Tổ yến được làm sạch lông & bụi bẩn đến hơn 95%. Mức độ nguyên chất ~98% sau khi xử lý. Tiết kiệm thời gian chế biến tối đa. Có thể bạn quan tâm: Tổ yến thượng hạng tiêu chuẩn thường 100g. Cách dùng tổ yến mang lại hiệu quả cao nhất Dùng tổ yến vào lúc đói sẽ giúp chất dinh dưỡng hấp thu nhanh và hiệu quả nhất. Tốt nhất nên dùng vào buổi sáng trước bữa ăn, buổi tối trước khi đi ngủ hoặc giữa các buổi. Chỉ nên dùng từ 3-5g tổ yến trong một lần. Một tuần không nên dùng quá 3 lần tổ yến. Đối với người bị cao huyết áp, nên dùng yến sào lúc đói, tránh để lạnh bụng gây khó chịu. Riêng với bệnh nhân tiểu đường, khi chưng yến bạn không nên cho nhiều đường phèn để tránh làm lượng đường trong máu tăng cao.', 0, 0, 0, 50, 3900000, N'qua-tet-tang-sep-cao-cap-3-600x600.jpg', N'10/27/22 7:44 AM', NULL, 3, 10, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (24, N'Hộp 3 hũ tổ yến cho trẻ em chưng sẵn', N'HYTE', N'Sản phẩm nước yến dinh dưỡng dành riêng cho trẻ em cực hấp dẫn chính hãng thương hiệu nước yến Win''snest với. Hộp 3 hũ tổ yến cho trẻ em chưng sẵn Win''snest Kid 70ml chính hãng, cam kết an toàn cho các bé, giúp bổ sung dinh dưỡng và tăng cường đề kháng', N'Sản xuất tạiViệt Nam Loại sản phẩmTổ yến Phần trăm yến20% Chế biếnchưng sẵn Thành phầnNước, yến sào (20%), lysin, đường tinh luyện, hương liệu tổng hợp dùng cho thực phẩm Lượng đườngNước yến có đường Thể tích70ml Đóng góiLốc nước yến sào Số lượngHộp 3 hũ', 0, 0, 0, 70, 700000, N'sellingpoint.jpg', N'10/27/22 7:47 AM', NULL, 1, 10, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (25, N'Tổ yến thô trắng cao cấp thượng hạng 100g Y067', N'Y067', N'Tổ yến thô trắng cao cấp thượng hạng 100g hay còn gọi là tổ yến nguyên thủy, tổ yến nguyên chất 100%, có mùi thơm đặt trưng, sợi yến nở nhiều, dai và rất dễ dàng nhận biết tổ yến thật giả. Tổ yến thô được lấy trực tiếp tại vùng biển Khánh Hòa – nơi có nguồn thức ăn béo ngậy cho yến dồi dào, dinh dưỡng cao cùng môi trường sống an toàn, trong lành', N'Hàng trăm năm nay, yến sào vốn nổi tiếng là một thứ cao lương mỹ vị, món ăn thượng hạng bậc nhất để tiến vua. Bên cạnh nguồn cung cấp yến vô cùng khan hiếm thì yến sào còn được biết đến rộng rãi với những cách chế biến độc đáo, đòi hỏi tinh tế và tỉ mỉ cũng như hàm lượng dinh dưỡng lớn. Với thành phần có chứa đến 18 loại acid amin (trong đó có rất nhiều loại không thể thay thế và hơn 31 loại nguyên tố đa vi lượng, các khoáng chất cần thiết cho cơ thể…hiếm có một loại thực phẩm cao cấp nào lại có công dụng bổ dưỡng và tốt với sức khỏe như tổ yến. Tại sao bạn nên lựa chọn Tổ yến thô trắng cao cấp thượng hạng 100g  Hiện nay trên thị trường có rất nhiều sản phẩm, chủng loại, thương hiệu yến sào khác nhau, Tổ yến thô trắng cao cấp thượng hạng 100g là một trong những sản phẩm chủ đạo, có vị thế trên thị trường.  Người tiêu dùng có thể tham khảo và lựa chọn sản phẩm nhờ những ưu điểm sau đây:  + Tổ yến thô trắng cao cấp thượng hạng 100g là sản phẩm có thương hiệu lớn, một trong những sản phẩm đầu ngành nên người tiêu dùng có thể yên tâm về chất lượng sản phẩm.  + Tổ yến thô trắng cao cấp thượng hạng 100g chưa qua quá trình tinh chế, vẫn giữ nguyên bản được những gì tinh túy nhất của thiên nhiên, môi trường Khánh Hòa, đảm bảo hàm lượng dưỡng chất và hiệu quả chăm sóc sức khỏe.  + Sản phẩm gồm nhiều tổ yến nhỏ thích hợp cho việc chế biến sử dụng, chia nhỏ liều lượng để có hiệu quả chăm sóc sức khỏe, tiết kiệm chi phí tốt nhất.  + Tổ yến thô trắng cao cấp thượng hạng 100g có mức giá phù hợp với nhiều điều kiện tiêu dùng. Với 100g bạn có thể chia nhỏ sử dụng, mỗi ngày chỉ bỏ ra vài chục nghìn đã có thể chăm sóc sức khỏe rất tốt.', 0, 0, 0, 100, 5000000, N'ct-yen-so-che-moi_07.jpg', N'10/27/22 7:49 AM', NULL, 8, 10, NULL)
INSERT [dbo].[product] ([product_id], [name], [code], [short_description], [full_description], [is_hot_selling], [is_outstanding], [is_latest], [weight], [price], [photo], [create_date], [edit_date], [category_id], [quantity], [supplier_id]) VALUES (26, N'Yến trắng tinh chế loại hộp 30g Y096', N'Y096', N'Yến trắng tinh chế thượng hạng 30g bao gồm các tổ yến trắng được khai thác trong nhà nuôi yến, là sản phẩm được nhiều khách hàng yêu thích và lựa chọn nhất của Song Ân Kiên Giang.', N'Tổ yến tinh chế đã được làm sạch hoàn toàn người dùng chỉ cần ngâm khoảng 15 phút và rửa sạch là có thể mang đem chế biến, rất thuận tiện, không mất thời gian làm sạch tổ.  Tổ yến được làm sạch theo quy trình hoàn toàn thủ công, chất lượng sản phẩm đáng ứng theo tiêu chuẩn ISO và HACCP.  Yến sào nổi tiếng là sản phẩm giàu giá trị bổ dưỡng, thành phần chất đạm cao (53 – 65%) cùng nhiều dưỡng chất quý giúp bồi bổ cơ thể, đặc biệt yến sào phù hợp với mọi đối tượng, ai cũng có thể ăn để tăng sức khỏe, sức đề kháng. ', 0, 0, 0, 30, 4900000, N'ava-hop-yen-tinh-che-30g.jpg', N'10/27/22 7:52 AM', NULL, 4, 50, NULL)
SET IDENTITY_INSERT [dbo].[product] OFF
GO
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (7, 2, 5)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (7, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (7, 1, 6)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (8, 1, 4)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (8, 2, 4)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (8, 3, 5)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (9, 1, 7)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (9, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (20, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (20, 2, 11)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (20, 3, 12)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (9, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (10, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (10, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (10, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (11, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (12, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (13, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (11, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (12, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (13, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (11, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (12, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (13, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (14, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (14, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (14, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (15, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (15, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (15, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (16, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (16, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (16, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (17, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (17, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (17, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (18, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (18, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (18, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (19, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (19, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (19, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (21, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (21, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (21, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (22, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (22, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (22, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (25, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (25, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (25, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (26, 1, 50)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (26, 2, 50)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (26, 3, 50)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (23, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (23, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (23, 3, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (24, 1, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (24, 2, 10)
INSERT [dbo].[quantity_product] ([product_id], [branch_id], [quantity]) VALUES (24, 3, 10)
GO
SET IDENTITY_INSERT [dbo].[user_role] ON 

INSERT [dbo].[user_role] ([role_id], [role]) VALUES (1, N'customer')
INSERT [dbo].[user_role] ([role_id], [role]) VALUES (2, N'staff')
INSERT [dbo].[user_role] ([role_id], [role]) VALUES (3, N'admin')
INSERT [dbo].[user_role] ([role_id], [role]) VALUES (4, N'supplier')
INSERT [dbo].[user_role] ([role_id], [role]) VALUES (5, N'shipper')
SET IDENTITY_INSERT [dbo].[user_role] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (1, N' ', N'admin', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'ghgh@fgjj.com', N'-89', 1, N'9/27/22 4:40 PM', NULL, 3)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (2, N'Test Customer Ax', N'Customer', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'customer@gmail.com', N'0986438258', 1, N'Sep 27 2022  7:07PM', NULL, 1)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (3, N'Test Admin A', N'Admin', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'admin@gmail.com', N'333333333', 1, N'Sep 27 2022  7:07PM', NULL, 3)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (4, N'Test Staff A', N'Staff', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'staff@gmail.com', N'222222222', 1, N'Sep 27 2022  7:07PM', NULL, 2)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (5, N'Test Supplier A', N'Supplier', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'supplier@gmail.com', N'444444444', 1, N'Sep 27 2022  7:07PM', NULL, 4)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (6, N'Test Shipper A', N'Shipper', N'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', N'shipper@gmail.com', N'555555555', 1, N'Sep 27 2022  7:07PM', NULL, 5)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (7, N'KHTN Holdings', NULL, N'123456', N'khtnholdings.work@gmail.com', N'0986438215', 1, N'10/4/22 4:59 PM', NULL, 1)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (8, N'Tran Khang', NULL, NULL, N'quockhang0603@gmail.com', NULL, 1, N'10/9/22 12:24 PM', NULL, 1)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (9, N'Tran Quoc Khang (K16_HCM)', NULL, NULL, N'khangtqse161548@fpt.edu.vn', NULL, 1, N'10/9/22 2:49 PM', NULL, 1)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (10, N'Pham Nhat', NULL, NULL, N'nhat2up@gmail.com', NULL, 1, N'10/17/22 2:49 PM', NULL, 1)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (11, N'Hung Le Nguyen', NULL, NULL, N'lnhungtn789@gmail.com', NULL, 1, N'21:06 03/11/2022', NULL, 1)
INSERT [dbo].[users] ([user_id], [full_name], [user_name], [password], [email], [phone], [status], [create_date], [edited_date], [role_id]) VALUES (12, N'hung', N'aa', N'91b4d142823f7d20c5f08df69122de43f35f057a988d9619f6d3138485c9a203', N'lll@gmail.com', N'0915426959', 1, N'21:15 03/11/2022', NULL, 2)
SET IDENTITY_INSERT [dbo].[users] OFF
GO
INSERT [dbo].[wishlist] ([create_date], [user_id], [product_id]) VALUES (N'21:06 03/11/2022', 11, 7)
GO
ALTER TABLE [dbo].[product] ADD  DEFAULT ((0)) FOR [is_hot_selling]
GO
ALTER TABLE [dbo].[product] ADD  DEFAULT ((0)) FOR [is_outstanding]
GO
ALTER TABLE [dbo].[product] ADD  DEFAULT ((0)) FOR [is_latest]
GO
ALTER TABLE [dbo].[branch]  WITH CHECK ADD FOREIGN KEY([location_id])
REFERENCES [dbo].[location] ([location_id])
GO
ALTER TABLE [dbo].[feedback]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[feedback]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([user_id])
GO
ALTER TABLE [dbo].[import_invoice]  WITH CHECK ADD FOREIGN KEY([branch_id])
REFERENCES [dbo].[branch] ([branch_id])
GO
ALTER TABLE [dbo].[import_invoice]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD FOREIGN KEY([location_id])
REFERENCES [dbo].[location] ([location_id])
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([user_id])
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[order] ([order_id])
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([category_id])
GO
ALTER TABLE [dbo].[quantity_product]  WITH CHECK ADD FOREIGN KEY([branch_id])
REFERENCES [dbo].[branch] ([branch_id])
GO
ALTER TABLE [dbo].[quantity_product]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD FOREIGN KEY([role_id])
REFERENCES [dbo].[user_role] ([role_id])
GO
ALTER TABLE [dbo].[wishlist]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[wishlist]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([user_id])
GO
USE [master]
GO
ALTER DATABASE [NestSongAn] SET  READ_WRITE 
GO
