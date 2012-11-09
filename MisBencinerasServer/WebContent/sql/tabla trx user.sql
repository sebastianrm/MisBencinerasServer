
CREATE TABLE [dbo].[precios](
	[precio] [float] NOT NULL,
	[fkbencina] [varchar](100) NOT NULL,
	[fkempresa] [varchar](100) NOT NULL,
	[fkdireccion] [varchar](150) NOT NULL,
	[fkregion] [varchar](100) NOT NULL,
	[fecha_actualizacion] [datetime] NOT NULL,
	[fklatitud] [float] NOT NULL,
	[fklongitud] [float] NOT NULL,
 CONSTRAINT [PK_precios] PRIMARY KEY CLUSTERED 
(
	[precio] ASC,
	[fkbencina] ASC,
	[fkempresa] ASC,
	[fkdireccion] ASC,
	[fkregion] ASC,
	[fecha_actualizacion] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]




CREATE TABLE [dbo].[trxuser](
	[bencina] [varchar](100) NOT NULL,
	[empresa] [varchar](100) NOT NULL,
	[latBencinera] [float] NOT NULL,
	[longBencinera] [float] NOT NULL,
	[key] [varchar](100) NOT NULL,
	[latUser] [float] NOT NULL,
	[longUser] [float] NOT NULL,
	[fecha_hora_consulta] [datetime] NOT NULL,
	[precio] [float] NOT NULL,
	[distancia] [float] NOT NULL,
 CONSTRAINT [PK_trxuser] PRIMARY KEY CLUSTERED 
(
	[bencina] ASC,
	[empresa] ASC,
	[latBencinera] ASC,
	[longBencinera] ASC,
	[key] ASC,
	[latUser] ASC,
	[longUser] ASC,
	[fecha_hora_consulta] ASC,
	[precio] ASC,
	[distancia] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]






DELETE FROM [Bencineras].[dbo].[bencinas];

DELETE FROM [Bencineras].[dbo].[direcciones_google];

DELETE FROM [Bencineras].[dbo].[precios];


DELETE FROM [Bencineras].[dbo].[servicentros];

DELETE FROM [Bencineras].[dbo].[regiones];