USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarEspecialidad')
    BEGIN
        DROP PROCEDURE uspListarEspecialidad
    END
GO

CREATE PROCEDURE uspListarEspecialidad

@IndOpSp int,
@idEspecialidad int,
@descripcion nvarchar(200),
@idCapitulo int,
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idEspecialidad, descripcion, idCapitulo, estado
        FROM Especialidad
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idEspecialidad, descripcion, idCapitulo, estado
        FROM Especialidad
        WHERE idEspecialidad=@idEspecialidad AND estado=1
    END

GO
