USE dbCIPAYACUCHO
GO

IF EXISTS (SELECT * FROM sysobjects WHERE type = 'P' AND name = 'uspListarConceptopago')
    BEGIN
        DROP PROCEDURE uspListarConceptopago
    END
GO

CREATE PROCEDURE uspListarConceptopago

@IndOpSp int,
@idConceptoPago int,
@descripcion nvarchar(100),
@fechaCreacion datetime,
@montoUnitario decimal(9,4),
@fechaModificacion datetime,
@estado bit

AS

IF (@IndOpSp=1)
    BEGIN
        SELECT idConceptoPago, descripcion, fechaCreacion, montoUnitario, fechaModificacion, estado
        FROM ConceptoPago
        WHERE estado=1
    END

IF (@IndOpSp=2)
    BEGIN
        SELECT idConceptoPago, descripcion, fechaCreacion, montoUnitario, fechaModificacion, estado
        FROM ConceptoPago
        WHERE idConceptoPago=@idConceptoPago AND estado=1
    END

GO
