USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarDepartamento')
    BEGIN
        DROP PROCEDURE uspListarDepartamento
    END
GO

CREATE PROCEDURE uspListarDepartamento

@IndOpSp int,
@idDepartamento nvarchar(2),
@descripcion nvarchar(100),
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idDepartamento, descripcion, estado
        FROM Departamento
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idDepartamento, descripcion, estado
        FROM Departamento
        WHERE idDepartamento=@idDepartamento AND estado=1
    END

GO
