USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarComprobantepago')
    BEGIN
        DROP PROCEDURE uspInsertarComprobantepago
    END
GO

CREATE PROCEDURE uspInsertarComprobantepago

@descripcion nvarchar(50),
@estado bit

AS

DECLARE @idComprobantePago int;
SELECT @idComprobantePago =  ISNULL(MAX(idComprobantePago),0)+1 FROM ComprobantePago;

INSERT INTO ComprobantePago (idComprobantePago, descripcion, estado)
VALUES (@idComprobantePago, @descripcion, @estado)

SELECT MAX(idComprobantePago)
FROM ComprobantePago

GO
