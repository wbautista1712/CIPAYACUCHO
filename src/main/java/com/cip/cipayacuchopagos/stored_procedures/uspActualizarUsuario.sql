USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspActualizarUsuario')
    BEGIN
        DROP PROCEDURE uspActualizarUsuario
    END
GO

CREATE PROCEDURE uspActualizarUsuario

@idUsuario int,
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

UPDATE Usuario SET idUsuario = @idUsuario, apPaterno = @apPaterno, apMaterno = @apMaterno, nombres = @nombres, idTipoDocumento = @idTipoDocumento, nroDocumento = @nroDocumento, email = @email, celular = @celular, direccion = @direccion, clave = @clave, idDistrito = @idDistrito, idCategoriaCIP = @idCategoriaCIP, idEspecialidad = @idEspecialidad, estado = @estado
WHERE idUsuario = @idUsuario

GO
