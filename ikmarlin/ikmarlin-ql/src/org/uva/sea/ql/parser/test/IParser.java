package org.uva.sea.ql.parser.test;


public interface IParser<T> {

	public abstract T parse(String src) throws ParseError;

}