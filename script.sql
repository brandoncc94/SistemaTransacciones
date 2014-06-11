USE [master]
GO
/****** Object:  Database [SistemaTransacciones]    Script Date: 11/06/2014 11:32:55 ******/
CREATE DATABASE [SistemaTransacciones]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SistemaTransacciones', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\SistemaTransacciones.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'SistemaTransacciones_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\SistemaTransacciones_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [SistemaTransacciones] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SistemaTransacciones].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SistemaTransacciones] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET ARITHABORT OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [SistemaTransacciones] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SistemaTransacciones] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SistemaTransacciones] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SistemaTransacciones] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SistemaTransacciones] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET RECOVERY FULL 
GO
ALTER DATABASE [SistemaTransacciones] SET  MULTI_USER 
GO
ALTER DATABASE [SistemaTransacciones] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SistemaTransacciones] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SistemaTransacciones] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SistemaTransacciones] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'SistemaTransacciones', N'ON'
GO
USE [SistemaTransacciones]
GO
/****** Object:  StoredProcedure [dbo].[SPUCambiarContraseña]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Brandon Campos Calderón
-- Create date: 09/06/2014
-- Description:	Procedimiento almancenado que verifica el inicio de sesión.
-- =============================================
CREATE PROCEDURE [dbo].[SPUCambiarContraseña]
	@idUsuario int,
	@password varchar(100)
AS
BEGIN
	SET NOCOUNT ON
	
	UPDATE Usuarios
	SET password = @password
	WHERE idUsuario = @idUsuario

END


GO
/****** Object:  StoredProcedure [dbo].[SPUConsultarInicioDeSesion]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Brandon Campos Calderón
-- Create date: 09/06/2014
-- Description:	Procedimiento almancenado que verifica el inicio de sesión.
-- =============================================
CREATE PROCEDURE [dbo].[SPUConsultarInicioDeSesion]
	@usuario varchar(25),
	@password varchar(100)
AS
BEGIN
	SET NOCOUNT ON

	SELECT idUsuario, tipo
	FROM Usuarios u
	WHERE u.usuario = @usuario AND u.password = @password;

END


GO
/****** Object:  StoredProcedure [dbo].[SPUCrearAgente]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Brandon Campos Calderón
-- Create date: 09/06/2014
-- Description:	Procedimiento almancenado que verifica el inicio de sesión.
-- =============================================
CREATE PROCEDURE [dbo].[SPUCrearAgente]
	@nombre varchar(25),
	@apellidoP varchar(25),
	@apellidoM varchar(25),
	@usuario varchar(25),
	@password varchar(100),
	@tipo int,
	@agenciaId int

AS
BEGIN
	SET NOCOUNT ON
	
	INSERT INTO Usuarios
	VALUES(@nombre, @apellidoP, @apellidoM, @usuario, @password, @tipo);

	DECLARE @idUsuario int;
	(SELECT @idUsuario = u.idUsuario  FROM Usuarios u WHERE  u.idUsuario = IDENT_CURRENT('Usuario'));

	UPDATE Agentes
	SET agenciaId = @agenciaId
	WHERE usuarioId = @idUsuario

END


GO
/****** Object:  StoredProcedure [dbo].[SPUObtenerNombre]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Brandon Campos Calderón
-- Create date: 09/06/2014
-- Description:	Procedimiento almancenado que verifica el inicio de sesión.
-- =============================================
CREATE PROCEDURE [dbo].[SPUObtenerNombre]
	@idUsuario int
AS
BEGIN
	SET NOCOUNT ON

	SELECT nombre, apellidoP, apellidoM
	FROM Usuarios 
	WHERE idUsuario = @idUsuario;

END


GO
/****** Object:  StoredProcedure [dbo].[SPUObtenerPassword]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Brandon Campos Calderón
-- Create date: 09/06/2014
-- Description:	Procedimiento almancenado que verifica el inicio de sesión.
-- =============================================
CREATE PROCEDURE [dbo].[SPUObtenerPassword]
	@idUsuario int
AS
BEGIN
	SET NOCOUNT ON

	SELECT password
	FROM Usuarios 
	WHERE idUsuario = @idUsuario;

END


GO
/****** Object:  Table [dbo].[Administradores]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administradores](
	[usuarioId] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Agencias]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Agencias](
	[idAgencia] [int] NOT NULL,
	[nombre] [varchar](30) NULL,
 CONSTRAINT [PK_Agencia] PRIMARY KEY CLUSTERED 
(
	[idAgencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Agentes]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Agentes](
	[usuarioId] [int] NOT NULL,
	[agenciaId] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cuentas]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cuentas](
	[idCuenta] [int] NOT NULL,
	[isDolar] [bit] NULL,
	[saldo] [money] NULL,
	[montoCongelado] [money] NULL,
 CONSTRAINT [PK_Cuenta] PRIMARY KEY CLUSTERED 
(
	[idCuenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Historial_Cuentas]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Historial_Cuentas](
	[idCuenta] [int] NOT NULL,
	[monto] [money] NULL,
	[tipoMovimiento] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HistorialTransacciones]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HistorialTransacciones](
	[sesionId] [int] NOT NULL,
	[transaccionId] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Negociaciones]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Negociaciones](
	[idNegociacion] [int] NOT NULL,
	[tipoCambioProm] [money] NULL,
	[idOfertaEmisora] [int] NOT NULL,
	[idOfertaReceptora] [int] NOT NULL,
	[fecha] [date] NULL,
 CONSTRAINT [PK_Negociacion] PRIMARY KEY CLUSTERED 
(
	[idNegociacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Ofertas]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ofertas](
	[idOferta] [int] IDENTITY(1,1) NOT NULL,
	[isCompra] [bit] NULL,
	[monto] [money] NULL,
	[tipoCambio] [money] NULL,
	[usuarioId] [int] NOT NULL,
	[isActiva] [bit] NULL,
	[idSesion] [int] NOT NULL,
 CONSTRAINT [PK_Oferta] PRIMARY KEY CLUSTERED 
(
	[idOferta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Participantes_Cuentas]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Participantes_Cuentas](
	[idCuenta] [int] NOT NULL,
	[participanteId] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Partipantes]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Partipantes](
	[cedula] [int] NULL,
	[fechaNac] [date] NULL,
	[correo] [varchar](50) NULL,
	[telefono] [int] NULL,
	[direccion] [varchar](80) NULL,
	[isActivo] [bit] NULL,
	[usuarioId] [int] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Sesiones]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sesiones](
	[idSesion] [int] IDENTITY(1,1) NOT NULL,
	[adminId] [int] NOT NULL,
	[porcentComision] [int] NULL,
 CONSTRAINT [PK_Sesion] PRIMARY KEY CLUSTERED 
(
	[idSesion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Transacciones]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transacciones](
	[idTransaccion] [int] NOT NULL,
	[tipoCambio] [money] NULL,
	[montoTransado] [money] NULL,
	[isDeposito] [bit] NULL,
	[fecha] [date] NULL,
	[negociacionId] [int] NOT NULL,
	[tipo] [int] NULL,
	[agenteId] [int] NOT NULL,
 CONSTRAINT [PK_Transaccion] PRIMARY KEY CLUSTERED 
(
	[idTransaccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Usuarios](
	[idUsuario] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](20) NULL,
	[apellidoP] [varchar](20) NULL,
	[apellidoM] [varchar](20) NULL,
	[usuario] [varchar](20) NULL,
	[password] [varchar](100) NULL,
	[tipo] [char](1) NULL,
 CONSTRAINT [PK_Participante_1] PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Administradores] ([usuarioId]) VALUES (4)
INSERT [dbo].[Administradores] ([usuarioId]) VALUES (5)
INSERT [dbo].[Agencias] ([idAgencia], [nombre]) VALUES (0, N'Default')
INSERT [dbo].[Agencias] ([idAgencia], [nombre]) VALUES (1, N'Agencia Solís')
INSERT [dbo].[Agencias] ([idAgencia], [nombre]) VALUES (2, N'Agencia Rodríguez')
INSERT [dbo].[Agencias] ([idAgencia], [nombre]) VALUES (3, N'Agencia Espinoza')
INSERT [dbo].[Agencias] ([idAgencia], [nombre]) VALUES (4, N'Agencia Campos')
INSERT [dbo].[Agentes] ([usuarioId], [agenciaId]) VALUES (16, 0)
INSERT [dbo].[Partipantes] ([cedula], [fechaNac], [correo], [telefono], [direccion], [isActivo], [usuarioId]) VALUES (0, CAST(0xA0380B00 AS Date), N'', 0, N'', 1, 17)
SET IDENTITY_INSERT [dbo].[Usuarios] ON 

INSERT [dbo].[Usuarios] ([idUsuario], [nombre], [apellidoP], [apellidoM], [usuario], [password], [tipo]) VALUES (4, N'Brandon', N'Campos', N'Calderón', N'brandoncc94', N'fc275ac3498d6ab0f0b4389f8e94422c', N'1')
INSERT [dbo].[Usuarios] ([idUsuario], [nombre], [apellidoP], [apellidoM], [usuario], [password], [tipo]) VALUES (5, N'Fabiola', N'Espinoza', N'Hernández', N'fabi9414', N'e10adc3949ba59abbe56e057f20f883e', N'1')
INSERT [dbo].[Usuarios] ([idUsuario], [nombre], [apellidoP], [apellidoM], [usuario], [password], [tipo]) VALUES (16, N'Jhoel', N'Marenco', N'Godoy', N'jhoelmg', N'e10adc3949ba59abbe56e057f20f883e', N'2')
INSERT [dbo].[Usuarios] ([idUsuario], [nombre], [apellidoP], [apellidoM], [usuario], [password], [tipo]) VALUES (17, N'Juan Carlos', N'Martínez', N'Ramírez', N'juancar1994', N'e10adc3949ba59abbe56e057f20f883e', N'3')
SET IDENTITY_INSERT [dbo].[Usuarios] OFF
/****** Object:  Index [IX_Administrador]    Script Date: 11/06/2014 11:32:55 ******/
ALTER TABLE [dbo].[Administradores] ADD  CONSTRAINT [IX_Administrador] UNIQUE NONCLUSTERED 
(
	[usuarioId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Agentes]    Script Date: 11/06/2014 11:32:55 ******/
ALTER TABLE [dbo].[Agentes] ADD  CONSTRAINT [IX_Agentes] UNIQUE NONCLUSTERED 
(
	[usuarioId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Partipante]    Script Date: 11/06/2014 11:32:55 ******/
ALTER TABLE [dbo].[Partipantes] ADD  CONSTRAINT [IX_Partipante] UNIQUE NONCLUSTERED 
(
	[usuarioId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Administradores]  WITH CHECK ADD  CONSTRAINT [FK_Administrador_Usuario] FOREIGN KEY([usuarioId])
REFERENCES [dbo].[Usuarios] ([idUsuario])
GO
ALTER TABLE [dbo].[Administradores] CHECK CONSTRAINT [FK_Administrador_Usuario]
GO
ALTER TABLE [dbo].[Agentes]  WITH CHECK ADD  CONSTRAINT [FK_Agente_Agencia] FOREIGN KEY([agenciaId])
REFERENCES [dbo].[Agencias] ([idAgencia])
GO
ALTER TABLE [dbo].[Agentes] CHECK CONSTRAINT [FK_Agente_Agencia]
GO
ALTER TABLE [dbo].[Agentes]  WITH CHECK ADD  CONSTRAINT [FK_Agente_Usuario] FOREIGN KEY([usuarioId])
REFERENCES [dbo].[Usuarios] ([idUsuario])
GO
ALTER TABLE [dbo].[Agentes] CHECK CONSTRAINT [FK_Agente_Usuario]
GO
ALTER TABLE [dbo].[Historial_Cuentas]  WITH CHECK ADD  CONSTRAINT [FK_Historial_Cuentas_Cuenta1] FOREIGN KEY([idCuenta])
REFERENCES [dbo].[Cuentas] ([idCuenta])
GO
ALTER TABLE [dbo].[Historial_Cuentas] CHECK CONSTRAINT [FK_Historial_Cuentas_Cuenta1]
GO
ALTER TABLE [dbo].[HistorialTransacciones]  WITH CHECK ADD  CONSTRAINT [FK_HistorialTransacciones_Sesion] FOREIGN KEY([sesionId])
REFERENCES [dbo].[Sesiones] ([idSesion])
GO
ALTER TABLE [dbo].[HistorialTransacciones] CHECK CONSTRAINT [FK_HistorialTransacciones_Sesion]
GO
ALTER TABLE [dbo].[HistorialTransacciones]  WITH CHECK ADD  CONSTRAINT [FK_HistorialTransacciones_Transaccion] FOREIGN KEY([transaccionId])
REFERENCES [dbo].[Transacciones] ([idTransaccion])
GO
ALTER TABLE [dbo].[HistorialTransacciones] CHECK CONSTRAINT [FK_HistorialTransacciones_Transaccion]
GO
ALTER TABLE [dbo].[Ofertas]  WITH CHECK ADD  CONSTRAINT [FK_Oferta_Partipante] FOREIGN KEY([usuarioId])
REFERENCES [dbo].[Partipantes] ([usuarioId])
GO
ALTER TABLE [dbo].[Ofertas] CHECK CONSTRAINT [FK_Oferta_Partipante]
GO
ALTER TABLE [dbo].[Ofertas]  WITH CHECK ADD  CONSTRAINT [FK_Oferta_Sesion] FOREIGN KEY([idSesion])
REFERENCES [dbo].[Sesiones] ([idSesion])
GO
ALTER TABLE [dbo].[Ofertas] CHECK CONSTRAINT [FK_Oferta_Sesion]
GO
ALTER TABLE [dbo].[Participantes_Cuentas]  WITH CHECK ADD  CONSTRAINT [FK_Historial_Cuentas_Cuenta] FOREIGN KEY([idCuenta])
REFERENCES [dbo].[Cuentas] ([idCuenta])
GO
ALTER TABLE [dbo].[Participantes_Cuentas] CHECK CONSTRAINT [FK_Historial_Cuentas_Cuenta]
GO
ALTER TABLE [dbo].[Participantes_Cuentas]  WITH CHECK ADD  CONSTRAINT [FK_Historial_Cuentas_Partipante] FOREIGN KEY([participanteId])
REFERENCES [dbo].[Partipantes] ([usuarioId])
GO
ALTER TABLE [dbo].[Participantes_Cuentas] CHECK CONSTRAINT [FK_Historial_Cuentas_Partipante]
GO
ALTER TABLE [dbo].[Partipantes]  WITH CHECK ADD  CONSTRAINT [FK_Partipante_Usuario] FOREIGN KEY([usuarioId])
REFERENCES [dbo].[Usuarios] ([idUsuario])
GO
ALTER TABLE [dbo].[Partipantes] CHECK CONSTRAINT [FK_Partipante_Usuario]
GO
ALTER TABLE [dbo].[Sesiones]  WITH CHECK ADD  CONSTRAINT [FK_Sesion_Administrador] FOREIGN KEY([adminId])
REFERENCES [dbo].[Administradores] ([usuarioId])
GO
ALTER TABLE [dbo].[Sesiones] CHECK CONSTRAINT [FK_Sesion_Administrador]
GO
ALTER TABLE [dbo].[Transacciones]  WITH CHECK ADD  CONSTRAINT [FK_Transacciones_Agentes] FOREIGN KEY([agenteId])
REFERENCES [dbo].[Agentes] ([usuarioId])
GO
ALTER TABLE [dbo].[Transacciones] CHECK CONSTRAINT [FK_Transacciones_Agentes]
GO
/****** Object:  Trigger [dbo].[UsuarioAdministrador]    Script Date: 11/06/2014 11:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[UsuarioAdministrador] 
	ON [dbo].[Usuarios]
	AFTER INSERT
AS
	DECLARE 
	@tipo char(1),
	@idUsuario INT;

	(SELECT @tipo = i.tipo FROM inserted AS i);
	
	(SELECT @idUsuario = i.idUsuario FROM inserted AS i);
	IF @tipo = 1
		INSERT INTO Administradores VALUES(@idUsuario);
	ELSE IF @tipo = 2
		INSERT INTO Agentes VALUES(@idUsuario, '0');
	ELSE
		INSERT INTO Partipantes VALUES(0, '09/06/2014', '','','',1, @idUsuario);

GO
USE [master]
GO
ALTER DATABASE [SistemaTransacciones] SET  READ_WRITE 
GO
