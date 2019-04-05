package pt.compta.thekitchensink;

public interface Converter<F, X> {
	F convert(X source);
}
