USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspInsertarEspecialidad')
    BEGIN
        DROP PROCEDURE uspInsertarEspecialidad
    END
GO

CREATE PROCEDURE uspInsertarEspecialidad

@descripcion nvarchar(200),
@idCapitulo int,
@estado bit

AS

DECLARE @idEspecialidad int;
SELECT @idEspecialidad =  ISNULL(MAX(idEspecialidad),0)+1 FROM Especialidad;

INSERT INTO Especialidad (idEspecialidad, descripcion, idCapitulo, estado)
VALUES (@idEspecialidad, @descripcion, @idCapitulo, @estado)

SELECT MAX(idEspecialidad)
FROM Especialidad

GO
