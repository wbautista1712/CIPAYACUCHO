USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarTipodocumento')
    BEGIN
        DROP PROCEDURE uspInsertarTipodocumento
    END
GO

CREATE PROCEDURE uspInsertarTipodocumento

@descripcion nvarchar(20),
@estado bit

AS

DECLARE @idTipoDocumento int;
SELECT @idTipoDocumento =  ISNULL(MAX(idTipoDocumento),0)+1 FROM TipoDocumento;

INSERT INTO TipoDocumento (idTipoDocumento, descripcion, estado)
VALUES (@idTipoDocumento, @descripcion, @estado)

SELECT MAX(idTipoDocumento)
FROM TipoDocumento

GO
