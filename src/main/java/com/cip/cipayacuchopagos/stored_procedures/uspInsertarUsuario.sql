USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarUsuario')
    BEGIN
        DROP PROCEDURE uspInsertarUsuario
    END
GO

CREATE PROCEDURE uspInsertarUsuario

@apPaterno nvarchar(80),
@apMaterno nvarchar(80),
@nombres nvarchar(100),
@idTipoDocumento int,
@nroDocumento nvarchar(12),
@email nvarchar(100),
@celular nvarchar(12),
@direccion nvarchar(100),
@clave nvarchar(100),
@idDistrito nvarchar(6),
@idCategoriaCIP int,
@idEspecialidad int,
@estado bit

AS

DECLARE @idUsuario int;
SELECT @idUsuario =  ISNULL(MAX(idUsuario),0)+1 FROM Usuario;

INSERT INTO Usuario (idUsuario, apPaterno, apMaterno, nombres, idTipoDocumento, nroDocumento, email, celular, direccion, clave, idDistrito, idCategoriaCIP, idEspecialidad, estado)
VALUES (@idUsuario, @apPaterno, @apMaterno, @nombres, @idTipoDocumento, @nroDocumento, @email, @celular, @direccion, @clave, @idDistrito, @idCategoriaCIP, @idEspecialidad, @estado)

SELECT MAX(idUsuario)
FROM Usuario

GO
