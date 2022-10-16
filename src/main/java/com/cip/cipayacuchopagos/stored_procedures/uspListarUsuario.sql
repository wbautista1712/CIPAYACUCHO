USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarUsuario')
    BEGIN
        DROP PROCEDURE uspListarUsuario
    END
GO

CREATE PROCEDURE uspListarUsuario

@IndOpSp int,
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

IF (@IndOpSp=1)
    BEGIN
        SELECT idUsuario, apPaterno, apMaterno, nombres, idTipoDocumento, nroDocumento, email, celular, direccion, clave, idDistrito, idCategoriaCIP, idEspecialidad, estado
        FROM Usuario
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idUsuario, apPaterno, apMaterno, nombres, idTipoDocumento, nroDocumento, email, celular, direccion, clave, idDistrito, idCategoriaCIP, idEspecialidad, estado
        FROM Usuario
        WHERE idUsuario=@idUsuario AND estado=1
    END

GO
