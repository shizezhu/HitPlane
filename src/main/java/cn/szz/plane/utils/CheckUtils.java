package cn.szz.plane.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import cn.szz.plane.exception.CheckException;

/**
 * 数据校验工具
 *
 * @author Shi Zezhu
 * @date 2018年8月22日 下午4:24:46
 */
public class CheckUtils {

	@FunctionalInterface
	public interface VoidFunction {
		void run();
	}

	public static boolean isNull(Object value) {
		return value == null;
	}

	public static boolean notNull(Object value) {
		return !isNull(value);
	}

	public static <V> V ifIsNullGet(V value, V getValue) {
		return notNull(value) ? value : getValue;
	}

	public static <V> V ifIsNullGet(V value, Supplier<V> getFun) {
		return notNull(value) ? value : getFun.get();
	}

	public static <R> R ifIsNullOrElseGet(Object value, R getValue1, R getValue2) {
		return isNull(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsNullOrElseGet(Object value, Supplier<R> getFun, R getValue) {
		return isNull(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsNullOrElseGet(Object value, R getValue, Supplier<R> getFun) {
		return isNull(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsNullOrElseGet(V value, R getValue, Function<V, R> getFun) {
		return isNull(value) ? getValue : getFun.apply(value);
	}

	public static <V> V ifNotNullGet(V value, Function<V, V> getFun) {
		return isNull(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotNullOrElseGet(Object value, R getValue1, R getValue2) {
		return notNull(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotNullOrElseGet(Object value, Supplier<R> getFun, R getValue) {
		return notNull(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotNullOrElseGet(Object value, R getValue, Supplier<R> getFun) {
		return notNull(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotNullOrElseGet(V value, Function<V, R> getFun1, R getValue2) {
		return notNull(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsNull(Object value, VoidFunction fun) {
		if (isNull(value))
			fun.run();
	}

	public static void ifNotNull(Object value, VoidFunction fun) {
		if (notNull(value))
			fun.run();
	}

	public static <V> void ifNotNull(V value, Consumer<V> fun) {
		if (notNull(value))
			fun.accept(value);
	}

	public static void ifIsNullOrElse(Object value, VoidFunction fun1, VoidFunction fun2) {
		if (isNull(value))
			fun1.run();
		else
			fun2.run();
	}

	public static <V> void ifIsNullOrElse(V value, VoidFunction fun1, Consumer<V> fun2) {
		if (isNull(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotNullOrElse(Object value, VoidFunction fun1, VoidFunction fun2) {
		if (notNull(value))
			fun1.run();
		else
			fun2.run();
	}

	public static <V> void ifNotNullOrElse(V value, Consumer<V> fun1, VoidFunction fun2) {
		if (notNull(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isNull(Object value, String message) throws CheckException {
		isNull(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isNull(Object value, Ex ex) throws Ex {
		if (notNull(value))
			throw ex;
	}

	public static <Ex extends CheckException> void isNull(Supplier<Object> valueFun, Ex ex) throws Ex {
		isNull(valueFun.get(), ex);
	}

	public static <V> V notNull(V value, String message) throws CheckException {
		return notNull(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> V notNull(V value, Ex ex) throws Ex {
		if (isNull(value))
			throw ex;
		return value;
	}

	public static <V, Ex extends CheckException> V notNull(Supplier<V> valueFun, Ex ex) throws Ex {
		return notNull(valueFun.get(), ex);
	}

	public static boolean isEmpty(Collection<?> value) {
		return isNull(value) || value.isEmpty();
	}

	public static boolean notEmpty(Collection<?> value) {
		return !isEmpty(value);
	}

	public static <V extends Collection<?>> V ifIsEmptyGet(V value, V getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static <V extends Collection<?>> V ifIsEmptyGet(V value, Supplier<V> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(Collection<?> value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(Collection<?> value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(Collection<?> value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V extends Collection<?>, R> R ifIsEmptyOrElseGet(V value, R getValue, Function<V, R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static <V extends Collection<?>> V ifNotEmptyGet(V value, V getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static <V extends Collection<?>> V ifNotEmptyGet(V value, Supplier<V> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static <V extends Collection<?>> V ifNotEmptyGet(V value, Function<V, V> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(Collection<?> value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(Collection<?> value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(Collection<?> value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V extends Collection<?>, R> R ifNotEmptyOrElseGet(V value, Function<V, R> getFun, R getValue) {
		return notEmpty(value) ? getFun.apply(value) : getValue;
	}

	public static void ifIsEmpty(Collection<?> value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(Collection<?> value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static <V extends Collection<?>> void ifNotEmpty(V value, Consumer<V> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(Collection<?> value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static <V extends Collection<?>> void ifIsEmptyOrElse(V value, VoidFunction fun1, Consumer<V> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(Collection<?> value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static <V extends Collection<?>> void ifNotEmptyOrElse(V value, Consumer<V> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(Collection<?> value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(Collection<?> value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static <V extends Collection<?>> V notEmpty(V value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V extends Collection<?>, Ex extends CheckException> V notEmpty(V value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(Object[] value) {
		return isNull(value) || value.length == 0;
	}

	public static boolean notEmpty(Object[] value) {
		return !isEmpty(value);
	}

	public static <V> V[] ifIsEmptyGet(V[] value, V[] getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static <V> V[] ifIsEmptyGet(V[] value, Supplier<V[]> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(Object[] value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(Object[] value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(Object[] value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEmptyOrElseGet(V[] value, R getValue, Function<V[], R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static <V> V[] ifNotEmptyGet(V[] value, V[] getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static <V> V[] ifNotEmptyGet(V[] value, Supplier<V[]> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static <V> V[] ifNotEmptyGet(V[] value, Function<V[], V[]> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(Object[] value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(Object[] value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(Object[] value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEmptyOrElseGet(V[] value, Function<V[], R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(Object[] value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(Object[] value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static <V> void ifNotEmpty(V[] value, Consumer<V[]> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(Object[] value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static <V> void ifIsEmptyOrElse(V[] value, VoidFunction fun1, Consumer<V[]> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(Object[] value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static <V> void ifNotEmptyOrElse(V[] value, Consumer<V[]> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(Object[] value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(Object[] value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static <V> V[] notEmpty(V[] value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> V[] notEmpty(V[] value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(byte[] value) {
		return isNull(value) || value.length == 0;
	}

	public static boolean notEmpty(byte[] value) {
		return !isEmpty(value);
	}

	public static byte[] ifIsEmptyGet(byte[] value, byte[] getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static byte[] ifIsEmptyGet(byte[] value, Supplier<byte[]> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(byte[] value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(byte[] value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(byte[] value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEmptyOrElseGet(byte[] value, R getValue, Function<byte[], R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static byte[] ifNotEmptyGet(byte[] value, byte[] getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static byte[] ifNotEmptyGet(byte[] value, Supplier<byte[]> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static byte[] ifNotEmptyGet(byte[] value, Function<byte[], byte[]> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(byte[] value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(byte[] value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(byte[] value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEmptyOrElseGet(byte[] value, Function<byte[], R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(byte[] value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(byte[] value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(byte[] value, Consumer<byte[]> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(byte[] value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEmptyOrElse(byte[] value, VoidFunction fun1, Consumer<byte[]> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(byte[] value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEmptyOrElse(byte[] value, Consumer<byte[]> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(byte[] value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(byte[] value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static byte[] notEmpty(byte[] value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> byte[] notEmpty(byte[] value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(short[] value) {
		return isNull(value) || value.length == 0;
	}

	public static boolean notEmpty(short[] value) {
		return !isEmpty(value);
	}

	public static short[] ifIsEmptyGet(short[] value, short[] getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static short[] ifIsEmptyGet(short[] value, Supplier<short[]> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(short[] value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(short[] value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(short[] value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEmptyOrElseGet(short[] value, R getValue, Function<short[], R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static short[] ifNotEmptyGet(short[] value, short[] getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static short[] ifNotEmptyGet(short[] value, Supplier<short[]> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static short[] ifNotEmptyGet(short[] value, Function<short[], short[]> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(short[] value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(short[] value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(short[] value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEmptyOrElseGet(short[] value, Function<short[], R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(short[] value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(short[] value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(short[] value, Consumer<short[]> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(short[] value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEmptyOrElse(short[] value, VoidFunction fun1, Consumer<short[]> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(short[] value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEmptyOrElse(short[] value, Consumer<short[]> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(short[] value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(short[] value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static short[] notEmpty(short[] value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> short[] notEmpty(short[] value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(int[] value) {
		return isNull(value) || value.length == 0;
	}

	public static boolean notEmpty(int[] value) {
		return !isEmpty(value);
	}

	public static int[] ifIsEmptyGet(int[] value, int[] getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static int[] ifIsEmptyGet(int[] value, Supplier<int[]> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(int[] value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(int[] value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(int[] value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEmptyOrElseGet(int[] value, R getValue, Function<int[], R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static int[] ifNotEmptyGet(int[] value, int[] getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static int[] ifNotEmptyGet(int[] value, Supplier<int[]> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static int[] ifNotEmptyGet(int[] value, Function<int[], int[]> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(int[] value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(int[] value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(int[] value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEmptyOrElseGet(int[] value, Function<int[], R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(int[] value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(int[] value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(int[] value, Consumer<int[]> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(int[] value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEmptyOrElse(int[] value, VoidFunction fun1, Consumer<int[]> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(int[] value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEmptyOrElse(int[] value, Consumer<int[]> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(int[] value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(int[] value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static int[] notEmpty(int[] value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> int[] notEmpty(int[] value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(float[] value) {
		return isNull(value) || value.length == 0;
	}

	public static boolean notEmpty(float[] value) {
		return !isEmpty(value);
	}

	public static float[] ifIsEmptyGet(float[] value, float[] getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static float[] ifIsEmptyGet(float[] value, Supplier<float[]> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(float[] value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(float[] value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(float[] value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEmptyOrElseGet(float[] value, R getValue, Function<float[], R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static float[] ifNotEmptyGet(float[] value, float[] getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static float[] ifNotEmptyGet(float[] value, Supplier<float[]> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static float[] ifNotEmptyGet(float[] value, Function<float[], float[]> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(float[] value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(float[] value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(float[] value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEmptyOrElseGet(float[] value, Function<float[], R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(float[] value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(float[] value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(float[] value, Consumer<float[]> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(float[] value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEmptyOrElse(float[] value, VoidFunction fun1, Consumer<float[]> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(float[] value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEmptyOrElse(float[] value, Consumer<float[]> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(float[] value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(float[] value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static float[] notEmpty(float[] value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> float[] notEmpty(float[] value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(long[] value) {
		return isNull(value) || value.length == 0;
	}

	public static boolean notEmpty(long[] value) {
		return !isEmpty(value);
	}

	public static long[] ifIsEmptyGet(long[] value, long[] getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static long[] ifIsEmptyGet(long[] value, Supplier<long[]> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(long[] value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(long[] value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(long[] value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEmptyOrElseGet(long[] value, R getValue, Function<long[], R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static long[] ifNotEmptyGet(long[] value, long[] getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static long[] ifNotEmptyGet(long[] value, Supplier<long[]> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static long[] ifNotEmptyGet(long[] value, Function<long[], long[]> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(long[] value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(long[] value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(long[] value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEmptyOrElseGet(long[] value, Function<long[], R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(long[] value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(long[] value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(long[] value, Consumer<long[]> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(long[] value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEmptyOrElse(long[] value, VoidFunction fun1, Consumer<long[]> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(long[] value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEmptyOrElse(long[] value, Consumer<long[]> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(long[] value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(long[] value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static long[] notEmpty(long[] value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> long[] notEmpty(long[] value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(double[] value) {
		return isNull(value) || value.length == 0;
	}

	public static boolean notEmpty(double[] value) {
		return !isEmpty(value);
	}

	public static double[] ifIsEmptyGet(double[] value, double[] getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static double[] ifIsEmptyGet(double[] value, Supplier<double[]> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(double[] value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(double[] value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(double[] value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEmptyOrElseGet(double[] value, R getValue, Function<double[], R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static double[] ifNotEmptyGet(double[] value, double[] getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static double[] ifNotEmptyGet(double[] value, Supplier<double[]> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static double[] ifNotEmptyGet(double[] value, Function<double[], double[]> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(double[] value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(double[] value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(double[] value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEmptyOrElseGet(double[] value, Function<double[], R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(double[] value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(double[] value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(double[] value, Consumer<double[]> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(double[] value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEmptyOrElse(double[] value, VoidFunction fun1, Consumer<double[]> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(double[] value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEmptyOrElse(double[] value, Consumer<double[]> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(double[] value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(double[] value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static double[] notEmpty(double[] value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> double[] notEmpty(double[] value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(boolean[] value) {
		return isNull(value) || value.length == 0;
	}

	public static boolean notEmpty(boolean[] value) {
		return !isEmpty(value);
	}

	public static boolean[] ifIsEmptyGet(boolean[] value, boolean[] getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static boolean[] ifIsEmptyGet(boolean[] value, Supplier<boolean[]> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(boolean[] value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(boolean[] value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(boolean[] value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEmptyOrElseGet(boolean[] value, R getValue, Function<boolean[], R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static boolean[] ifNotEmptyGet(boolean[] value, boolean[] getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static boolean[] ifNotEmptyGet(boolean[] value, Supplier<boolean[]> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static boolean[] ifNotEmptyGet(boolean[] value, Function<boolean[], boolean[]> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(boolean[] value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(boolean[] value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(boolean[] value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEmptyOrElseGet(boolean[] value, Function<boolean[], R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(boolean[] value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(boolean[] value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(boolean[] value, Consumer<boolean[]> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(boolean[] value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEmptyOrElse(boolean[] value, VoidFunction fun1, Consumer<boolean[]> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(boolean[] value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEmptyOrElse(boolean[] value, Consumer<boolean[]> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(boolean[] value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(boolean[] value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static boolean[] notEmpty(boolean[] value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> boolean[] notEmpty(boolean[] value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(char[] value) {
		return isNull(value) || value.length == 0;
	}

	public static boolean notEmpty(char[] value) {
		return !isEmpty(value);
	}

	public static char[] ifIsEmptyGet(char[] value, char[] getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static char[] ifIsEmptyGet(char[] value, Supplier<char[]> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(char[] value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(char[] value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(char[] value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEmptyOrElseGet(char[] value, R getValue, Function<char[], R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static char[] ifNotEmptyGet(char[] value, char[] getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static char[] ifNotEmptyGet(char[] value, Supplier<char[]> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static char[] ifNotEmptyGet(char[] value, Function<char[], char[]> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(char[] value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(char[] value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(char[] value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEmptyOrElseGet(char[] value, Function<char[], R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(char[] value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(char[] value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(char[] value, Consumer<char[]> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(char[] value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEmptyOrElse(char[] value, VoidFunction fun1, Consumer<char[]> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(char[] value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEmptyOrElse(char[] value, Consumer<char[]> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(char[] value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(char[] value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static char[] notEmpty(char[] value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V, Ex extends CheckException> char[] notEmpty(char[] value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(Map<?, ?> value) {
		return isNull(value) || value.isEmpty();
	}

	public static boolean notEmpty(Map<?, ?> value) {
		return !isEmpty(value);
	}

	public static <V extends Map<?, ?>> V ifIsEmptyGet(V value, V getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static <V extends Map<?, ?>> V ifIsEmptyGet(V value, Supplier<V> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(Map<?, ?> value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(Map<?, ?> value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(Map<?, ?> value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <V extends Map<?, ?>, R> R ifIsEmptyOrElseGet(V value, R getValue, Function<V, R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static <V extends Map<?, ?>> V ifNotEmptyGet(V value, V getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static <V extends Map<?, ?>> V ifNotEmptyGet(V value, Supplier<V> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static <V extends Map<?, ?>> V ifNotEmptyGet(V value, Function<V, V> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(Map<?, ?> value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(Map<?, ?> value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(Map<?, ?> value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <V extends Map<?, ?>, R> R ifNotEmptyOrElseGet(V value, Function<V, R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(Map<?, ?> value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(Map<?, ?> value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static <V extends Map<?, ?>> void ifNotEmpty(V value, Consumer<V> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(Map<?, ?> value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static <V extends Map<?, ?>> void ifIsEmptyOrElse(V value, VoidFunction fun1, Consumer<V> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(Map<?, ?> value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static <V extends Map<?, ?>> void ifNotEmptyOrElse(V value, Consumer<V> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(Map<?, ?> value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(Map<?, ?> value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static <V extends Map<?, ?>> V notEmpty(V value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <V extends Map<?, ?>, Ex extends CheckException> V notEmpty(V value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isEmpty(String value) {
		int strLen;
		if (value == null || (strLen = value.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(value.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean notEmpty(String value) {
		return !isEmpty(value);
	}

	public static String ifIsEmptyGet(String value, String getValue) {
		return notEmpty(value) ? value : getValue;
	}

	public static String ifIsEmptyGet(String value, Supplier<String> getFun) {
		return notEmpty(value) ? value : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(String value, R getValue1, R getValue2) {
		return isEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEmptyOrElseGet(String value, Supplier<R> getFun, R getValue) {
		return isEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEmptyOrElseGet(String value, R getValue, Supplier<R> getFun) {
		return isEmpty(value) ? getValue : getFun.get();
	}

	public static <R> R ifIsEmptyOrElseGet(String value, R getValue, Function<String, R> getFun) {
		return isEmpty(value) ? getValue : getFun.apply(value);
	}

	public static String ifNotEmptyGet(String value, String getValue) {
		return isEmpty(value) ? value : getValue;
	}

	public static String ifNotEmptyGet(String value, Supplier<String> getFun) {
		return isEmpty(value) ? value : getFun.get();
	}

	public static String ifNotEmptyGet(String value, Function<String, String> getFun) {
		return isEmpty(value) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEmptyOrElseGet(String value, R getValue1, R getValue2) {
		return notEmpty(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEmptyOrElseGet(String value, Supplier<R> getFun, R getValue) {
		return notEmpty(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEmptyOrElseGet(String value, R getValue, Supplier<R> getFun) {
		return notEmpty(value) ? getValue : getFun.get();
	}

	public static <R> R ifNotEmptyOrElseGet(String value, Function<String, R> getFun1, R getValue2) {
		return notEmpty(value) ? getFun1.apply(value) : getValue2;
	}

	public static void ifIsEmpty(String value, VoidFunction fun) {
		if (isEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(String value, VoidFunction fun) {
		if (notEmpty(value))
			fun.run();
	}

	public static void ifNotEmpty(String value, Consumer<String> fun) {
		if (notEmpty(value))
			fun.accept(value);
	}

	public static void ifIsEmptyOrElse(String value, VoidFunction fun1, VoidFunction fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEmptyOrElse(String value, VoidFunction fun1, Consumer<String> fun2) {
		if (isEmpty(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEmptyOrElse(String value, VoidFunction fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEmptyOrElse(String value, Consumer<String> fun1, VoidFunction fun2) {
		if (notEmpty(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void isEmpty(String value, String message) throws CheckException {
		isEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> void isEmpty(String value, Ex ex) throws Ex {
		if (notEmpty(value))
			throw ex;
	}

	public static String notEmpty(String value, String message) throws CheckException {
		return notEmpty(value, new CheckException(message));
	}

	public static <Ex extends CheckException> String notEmpty(String value, Ex ex) throws Ex {
		if (isEmpty(value))
			throw ex;
		return value;
	}

	public static boolean isRegex(String value, String regex) {
		return notNull(value) && notNull(regex) && value.matches(regex);
	}

	public static boolean notRegex(String value, String regex) {
		return !isRegex(value, regex);
	}

	public static String ifIsRegexGet(String value, String regex, String getValue) {
		return notRegex(value, regex) ? value : getValue;
	}

	public static String ifIsRegexGet(String value, String regex, Supplier<String> getFun) {
		return notRegex(value, regex) ? value : getFun.get();
	}

	public static String ifIsRegexGet(String value, String regex, Function<String, String> getFun) {
		return notRegex(value, regex) ? value : getFun.apply(value);
	}

	public static <R> R ifIsRegexOrElseGet(String value, String regex, R getValue1, R getValue2) {
		return isRegex(value, regex) ? getValue1 : getValue2;
	}

	public static <R> R ifIsRegexOrElseGet(String value, String regex, Supplier<R> getFun, R getValue) {
		return isRegex(value, regex) ? getFun.get() : getValue;
	}

	public static <R> R ifIsRegexOrElseGet(String value, String regex, R getValue, Supplier<R> getFun) {
		return isRegex(value, regex) ? getValue : getFun.get();
	}

	public static <R> R ifIsRegexOrElseGet(String value, String regex, Function<String, R> getFun, R getValue) {
		return isRegex(value, regex) ? getFun.apply(value) : getValue;
	}

	public static <R> R ifIsRegexOrElseGet(String value, String regex, R getValue, Function<String, R> getFun) {
		return isRegex(value, regex) ? getValue : getFun.apply(value);
	}

	public static String ifNotRegexGet(String value, String regex, String getValue) {
		return isRegex(value, regex) ? value : getValue;
	}

	public static String ifNotRegexGet(String value, String regex, Supplier<String> getFun) {
		return isRegex(value, regex) ? value : getFun.get();
	}

	public static String ifNotRegexGet(String value, String regex, Function<String, String> getFun) {
		return isRegex(value, regex) ? value : getFun.apply(value);
	}

	public static <R> R ifNotRegexOrElseGet(String value, String regex, R getValue1, R getValue2) {
		return notRegex(value, regex) ? getValue1 : getValue2;
	}

	public static <R> R ifNotRegexOrElseGet(String value, String regex, Supplier<R> getFun, R getValue) {
		return notRegex(value, regex) ? getFun.get() : getValue;
	}

	public static <R> R ifNotRegexOrElseGet(String value, String regex, R getValue, Supplier<R> getFun) {
		return notRegex(value, regex) ? getValue : getFun.get();
	}

	public static <R> R ifNotRegexOrElseGet(String value, String regex, Function<String, R> getFun, R getValue) {
		return notRegex(value, regex) ? getFun.apply(value) : getValue;
	}

	public static <R> R ifNotRegexOrElseGet(String value, String regex, R getValue, Function<String, R> getFun) {
		return notRegex(value, regex) ? getValue : getFun.apply(value);
	}

	public static void ifIsRegex(String value, String regex, VoidFunction fun) {
		if (isRegex(value, regex))
			fun.run();
	}

	public static void ifIsRegex(String value, String regex, Consumer<String> fun) {
		if (isRegex(value, regex))
			fun.accept(value);
	}

	public static void ifNotRegex(String value, String regex, VoidFunction fun) {
		if (notRegex(value, regex))
			fun.run();
	}

	public static void ifNotRegex(String value, String regex, Consumer<String> fun) {
		if (notRegex(value, regex))
			fun.accept(value);
	}

	public static void ifIsRegexOrElse(String value, String regex, VoidFunction fun1, VoidFunction fun2) {
		if (isRegex(value, regex))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsRegexOrElse(String value, String regex, VoidFunction fun1, Consumer<String> fun2) {
		if (isRegex(value, regex))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifIsRegexOrElse(String value, String regex, Consumer<String> fun1, VoidFunction fun2) {
		if (isRegex(value, regex))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void ifIsRegexOrElse(String value, String regex, Consumer<String> fun1, Consumer<String> fun2) {
		if (isRegex(value, regex))
			fun1.accept(value);
		else
			fun2.accept(value);
	}

	public static void ifNotRegexOrElse(String value, String regex, VoidFunction fun1, VoidFunction fun2) {
		if (notRegex(value, regex))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotRegexOrElse(String value, String regex, Consumer<String> fun1, VoidFunction fun2) {
		if (notRegex(value, regex))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void ifNotRegexOrElse(String value, String regex, VoidFunction fun1, Consumer<String> fun2) {
		if (notRegex(value, regex))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotRegexOrElse(String value, String regex, Consumer<String> fun1, Consumer<String> fun2) {
		if (notRegex(value, regex))
			fun1.accept(value);
		else
			fun2.accept(value);
	}

	public static String isRegex(String value, String regex, String message) throws CheckException {
		return isRegex(value, regex, new CheckException(message));
	}

	public static <Ex extends CheckException> String isRegex(String value, String regex, Ex ex) throws Ex {
		if (notRegex(value, regex))
			throw ex;
		return value;
	}

	public static String notRegex(String value, String regex, String message) throws CheckException {
		return notRegex(value, regex, new CheckException(message));
	}

	public static <Ex extends CheckException> String notRegex(String value, String regex, Ex ex) throws Ex {
		if (isRegex(value, regex))
			throw ex;
		return value;
	}

	public static boolean isEquals(Object value1, Object value2) {
		return (value1 == value2) || (notNull(value1) && value1.equals(value2));
	}

	public static boolean notEquals(Object value1, Object value2) {
		return !isEquals(value1, value2);
	}

	public static <V> V ifIsEqualsGet(V value1, Object value2, V getValue) {
		return notEquals(value1, value2) ? value1 : getValue;
	}

	public static <V> V ifIsEqualsGet(V value1, Object value2, Supplier<V> getFun) {
		return notEquals(value1, value2) ? value1 : getFun.get();
	}

	public static <V> V ifIsEqualsGet(V value1, Object value2, Function<V, V> getFun) {
		return notEquals(value1, value2) ? value1 : getFun.apply(value1);
	}

	public static <R> R ifIsEqualsOrElseGet(Object value1, Object value2, R getValue1, R getValue2) {
		return isEquals(value1, value2) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEqualsOrElseGet(Object value1, Object value2, Supplier<R> getFun, R getValue) {
		return isEquals(value1, value2) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEqualsOrElseGet(Object value1, Object value2, R getValue, Supplier<R> getFun) {
		return isEquals(value1, value2) ? getValue : getFun.get();
	}

	public static <V, R> R ifIsEqualsOrElseGet(V value1, Object value2, Function<V, R> getFun, R getValue) {
		return isEquals(value1, value2) ? getFun.apply(value1) : getValue;
	}

	public static <V, R> R ifIsEqualsOrElseGet(V value1, Object value2, R getValue, Function<V, R> getFun) {
		return isEquals(value1, value2) ? getValue : getFun.apply(value1);
	}

	public static <V> V ifNotEqualsGet(V value1, Object value2, V getValue) {
		return isEquals(value1, value2) ? value1 : getValue;
	}

	public static <V> V ifNotEqualsGet(V value1, Object value2, Supplier<V> getFun) {
		return isEquals(value1, value2) ? value1 : getFun.get();
	}

	public static <V> V ifNotEqualsGet(V value1, Object value2, Function<V, V> getFun) {
		return isEquals(value1, value2) ? value1 : getFun.apply(value1);
	}

	public static <R> R ifNotEqualsOrElseGet(Object value1, Object value2, R getValue1, R getValue2) {
		return notEquals(value1, value2) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEqualsOrElseGet(Object value1, Object value2, Supplier<R> getFun, R getValue) {
		return notEquals(value1, value2) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEqualsOrElseGet(Object value1, Object value2, R getValue, Supplier<R> getFun) {
		return notEquals(value1, value2) ? getValue : getFun.get();
	}

	public static <V, R> R ifNotEqualsOrElseGet(V value1, Object value2, Function<V, R> getFun, R getValue) {
		return notEquals(value1, value2) ? getFun.apply(value1) : getValue;
	}

	public static <V, R> R ifNotEqualsOrElseGet(V value1, Object value2, R getValue, Function<V, R> getFun) {
		return notEquals(value1, value2) ? getValue : getFun.apply(value1);
	}

	public static void ifIsEquals(Object value1, Object value2, VoidFunction fun) {
		if (isEquals(value1, value2))
			fun.run();
	}

	public static <V> void ifIsEquals(V value1, Object value2, Consumer<V> fun) {
		if (isEquals(value1, value2))
			fun.accept(value1);
	}

	public static void ifNotEquals(Object value1, Object value2, VoidFunction fun) {
		if (notEquals(value1, value2))
			fun.run();
	}

	public static <V> void ifNotEquals(V value1, Object value2, Consumer<V> fun) {
		if (notEquals(value1, value2))
			fun.accept(value1);
	}

	public static void ifIsEqualsOrElse(Object value1, Object value2, VoidFunction fun1, VoidFunction fun2) {
		if (isEquals(value1, value2))
			fun1.run();
		else
			fun2.run();
	}

	public static <V> void ifIsEqualsOrElse(V value1, Object value2, VoidFunction fun1, Consumer<V> fun2) {
		if (isEquals(value1, value2))
			fun1.run();
		else
			fun2.accept(value1);
	}

	public static <V> void ifIsEqualsOrElse(V value1, Object value2, Consumer<V> fun1, VoidFunction fun2) {
		if (isEquals(value1, value2))
			fun1.accept(value1);
		else
			fun2.run();
	}

	public static <V> void ifIsEqualsOrElse(V value1, Object value2, Consumer<V> fun1, Consumer<V> fun2) {
		if (isEquals(value1, value2))
			fun1.accept(value1);
		else
			fun2.accept(value1);
	}

	public static void ifNotEqualsOrElse(Object value1, Object value2, VoidFunction fun1, VoidFunction fun2) {
		if (notEquals(value1, value2))
			fun1.run();
		else
			fun2.run();
	}

	public static <V> void ifNotEqualsOrElse(V value1, Object value2, Consumer<V> fun1, VoidFunction fun2) {
		if (notEquals(value1, value2))
			fun1.accept(value1);
		else
			fun2.run();
	}

	public static <V> void ifNotEqualsOrElse(V value1, Object value2, Consumer<V> fun1, Consumer<V> fun2) {
		if (notEquals(value1, value2))
			fun1.accept(value1);
		else
			fun2.accept(value1);
	}

	public static <V> void ifNotEqualsOrElse(V value1, Object value2, VoidFunction fun1, Consumer<V> fun2) {
		if (notEquals(value1, value2))
			fun1.run();
		else
			fun2.accept(value1);
	}

	public static <V> V isEquals(V value1, Object value2, String message) throws CheckException {
		return isEquals(value1, value2, new CheckException(message));
	}

	public static <V, Ex extends CheckException> V isEquals(V value1, Object value2, Ex ex) throws Ex {
		if (notEquals(value1, value2))
			throw ex;
		return value1;
	}

	public static <V> V notEquals(V value1, Object value2, String message) throws CheckException {
		return notEquals(value1, value2, new CheckException(message));
	}

	public static <V, Ex extends CheckException> V notEquals(V value1, Object value2, Ex ex) throws Ex {
		if (isEquals(value1, value2))
			throw ex;
		return value1;
	}

	public static boolean isEqualsIgnoreCase(String value1, String value2) {
		return (value1 == value2) || (notEmpty(value1) && value1.equalsIgnoreCase(value2));
	}

	public static boolean notEqualsIgnoreCase(String value1, String value2) {
		return !isEqualsIgnoreCase(value1, value2);
	}

	public static String ifIsEqualsIgnoreCaseGet(String value1, String value2, String getValue) {
		return notEqualsIgnoreCase(value1, value2) ? value1 : getValue;
	}

	public static String ifIsEqualsIgnoreCaseGet(String value1, String value2, Supplier<String> getFun) {
		return notEqualsIgnoreCase(value1, value2) ? value1 : getFun.get();
	}

	public static String ifIsEqualsIgnoreCaseGet(String value1, String value2, Function<String, String> getFun) {
		return notEqualsIgnoreCase(value1, value2) ? value1 : getFun.apply(value1);
	}

	public static <R> R ifIsEqualsIgnoreCaseOrElseGet(String value1, String value2, R getValue1, R getValue2) {
		return isEqualsIgnoreCase(value1, value2) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEqualsIgnoreCaseOrElseGet(String value1, String value2, Supplier<R> getFun, R getValue) {
		return isEqualsIgnoreCase(value1, value2) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEqualsIgnoreCaseOrElseGet(String value1, String value2, R getValue, Supplier<R> getFun) {
		return isEqualsIgnoreCase(value1, value2) ? getValue : getFun.get();
	}

	public static <R> R ifIsEqualsIgnoreCaseOrElseGet(String value1, String value2, Function<String, R> getFun,
			R getValue) {
		return isEqualsIgnoreCase(value1, value2) ? getFun.apply(value1) : getValue;
	}

	public static <R> R ifIsEqualsIgnoreCaseOrElseGet(String value1, String value2, R getValue,
			Function<String, R> getFun) {
		return isEqualsIgnoreCase(value1, value2) ? getValue : getFun.apply(value1);
	}

	public static String ifNotEqualsIgnoreCaseGet(String value1, String value2, String getValue) {
		return isEqualsIgnoreCase(value1, value2) ? value1 : getValue;
	}

	public static String ifNotEqualsIgnoreCaseGet(String value1, String value2, Supplier<String> getFun) {
		return isEqualsIgnoreCase(value1, value2) ? value1 : getFun.get();
	}

	public static String ifNotEqualsIgnoreCaseGet(String value1, String value2, Function<String, String> getFun) {
		return isEqualsIgnoreCase(value1, value2) ? value1 : getFun.apply(value1);
	}

	public static <R> R ifNotEqualsIgnoreCaseOrElseGet(String value1, String value2, R getValue1, R getValue2) {
		return notEqualsIgnoreCase(value1, value2) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEqualsIgnoreCaseOrElseGet(String value1, String value2, Supplier<R> getFun, R getValue) {
		return notEqualsIgnoreCase(value1, value2) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEqualsIgnoreCaseOrElseGet(String value1, String value2, R getValue, Supplier<R> getFun) {
		return notEqualsIgnoreCase(value1, value2) ? getValue : getFun.get();
	}

	public static <R> R ifNotEqualsIgnoreCaseOrElseGet(String value1, String value2, Function<String, R> getFun,
			R getValue) {
		return notEqualsIgnoreCase(value1, value2) ? getFun.apply(value1) : getValue;
	}

	public static <R> R ifNotEqualsIgnoreCaseOrElseGet(String value1, String value2, R getValue,
			Function<String, R> getFun) {
		return notEqualsIgnoreCase(value1, value2) ? getValue : getFun.apply(value1);
	}

	public static void ifIsEqualsIgnoreCase(String value1, String value2, VoidFunction fun) {
		if (isEqualsIgnoreCase(value1, value2))
			fun.run();
	}

	public static void ifIsEqualsIgnoreCase(String value1, String value2, Consumer<String> fun) {
		if (isEqualsIgnoreCase(value1, value2))
			fun.accept(value1);
	}

	public static void ifNotEqualsIgnoreCase(String value1, String value2, VoidFunction fun) {
		if (notEqualsIgnoreCase(value1, value2))
			fun.run();
	}

	public static void ifNotEqualsIgnoreCase(String value1, String value2, Consumer<String> fun) {
		if (notEqualsIgnoreCase(value1, value2))
			fun.accept(value1);
	}

	public static void ifIsEqualsIgnoreCaseOrElse(String value1, String value2, VoidFunction fun1, VoidFunction fun2) {
		if (isEqualsIgnoreCase(value1, value2))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEqualsIgnoreCaseOrElse(String value1, String value2, VoidFunction fun1,
			Consumer<String> fun2) {
		if (isEqualsIgnoreCase(value1, value2))
			fun1.run();
		else
			fun2.accept(value1);
	}

	public static void ifIsEqualsIgnoreCaseOrElse(String value1, String value2, Consumer<String> fun1,
			VoidFunction fun2) {
		if (isEqualsIgnoreCase(value1, value2))
			fun1.accept(value1);
		else
			fun2.run();
	}

	public static void ifIsEqualsIgnoreCaseOrElse(String value1, String value2, Consumer<String> fun1,
			Consumer<String> fun2) {
		if (isEqualsIgnoreCase(value1, value2))
			fun1.accept(value1);
		else
			fun2.accept(value1);
	}

	public static void ifNotEqualsIgnoreCaseOrElse(String value1, String value2, VoidFunction fun1, VoidFunction fun2) {
		if (notEqualsIgnoreCase(value1, value2))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEqualsIgnoreCaseOrElse(String value1, String value2, Consumer<String> fun1,
			VoidFunction fun2) {
		if (notEqualsIgnoreCase(value1, value2))
			fun1.accept(value1);
		else
			fun2.run();
	}

	public static void ifNotEqualsIgnoreCaseOrElse(String value1, String value2, VoidFunction fun1,
			Consumer<String> fun2) {
		if (notEqualsIgnoreCase(value1, value2))
			fun1.run();
		else
			fun2.accept(value1);
	}

	public static void ifNotEqualsIgnoreCaseOrElse(String value1, String value2, Consumer<String> fun1,
			Consumer<String> fun2) {
		if (notEqualsIgnoreCase(value1, value2))
			fun1.accept(value1);
		else
			fun2.accept(value1);
	}

	public static String isEqualsIgnoreCase(String value1, String value2, String message) throws CheckException {
		return isEqualsIgnoreCase(value1, value2, new CheckException(message));
	}

	public static <Ex extends CheckException> String isEqualsIgnoreCase(String value1, String value2, Ex ex) throws Ex {
		if (notEqualsIgnoreCase(value1, value2))
			throw ex;
		return value1;
	}

	public static String notEqualsIgnoreCase(String value1, String value2, String message) throws CheckException {
		return notEqualsIgnoreCase(value1, value2, new CheckException(message));
	}

	public static <Ex extends CheckException> String notEqualsIgnoreCase(String value1, String value2, Ex ex)
			throws Ex {
		if (isEqualsIgnoreCase(value1, value2))
			throw ex;
		return value1;
	}

	public static <R> R ifIsTrueOrElseGet(boolean value, R getValue1, R getValue2) {
		return value ? getValue1 : getValue2;
	}

	public static <R> R ifIsTrueOrElseGet(boolean value, Supplier<R> getFun, R getValue) {
		return value ? getFun.get() : getValue;
	}

	public static <R> R ifIsTrueOrElseGet(boolean value, R getValue, Supplier<R> getFun) {
		return value ? getValue : getFun.get();
	}

	public static void ifIsTrue(boolean value, VoidFunction fun) {
		if (value)
			fun.run();
	}

	public static void ifIsTrueOrElse(boolean value, VoidFunction fun1, VoidFunction fun2) {
		if (value)
			fun1.run();
		else
			fun2.run();
	}

	public static boolean isTrue(boolean value, String message) throws CheckException {
		return isTrue(value, new CheckException(message));
	}

	public static <Ex extends CheckException> boolean isTrue(boolean value, Ex ex) throws Ex {
		if (!value)
			throw ex;
		return value;
	}

	public static <R> R ifIsFalseOrElseGet(boolean value, R getValue1, R getValue2) {
		return !value ? getValue1 : getValue2;
	}

	public static <R> R ifIsFalseOrElseGet(boolean value, Supplier<R> getFun, R getValue) {
		return !value ? getFun.get() : getValue;
	}

	public static <R> R ifIsFalseOrElseGet(boolean value, R getValue, Supplier<R> getFun) {
		return !value ? getValue : getFun.get();
	}

	public static void ifIsFalse(boolean value, VoidFunction fun) {
		if (!value)
			fun.run();
	}

	public static void ifIsFalseOrElse(boolean value, VoidFunction fun1, VoidFunction fun2) {
		if (!value)
			fun1.run();
		else
			fun2.run();
	}

	public static boolean isFalse(boolean value, String message) throws CheckException {
		return isFalse(value, new CheckException(message));
	}

	public static <Ex extends CheckException> boolean isFalse(boolean value, Ex ex) throws Ex {
		if (value)
			throw ex;
		return value;
	}

	public static boolean isInt(String value) {
		if (isEmpty(value))
			return false;
		value = value.trim();
		int result = 0;
		int i = 0, len = value.length();
		int limit = -Integer.MAX_VALUE;
		int multmin;
		int digit;
		if (len <= 0)
			return false;
		char firstChar = value.charAt(0);
		if (firstChar < '0') {
			if (firstChar == '-') {
				limit = Integer.MIN_VALUE;
			} else if (firstChar != '+')
				return false;
			if (len == 1)
				return false;
			i++;
		}
		multmin = limit / 10;
		while (i < len) {
			digit = Character.digit(value.charAt(i++), 10);
			if (digit < 0)
				return false;
			if (result < multmin)
				return false;
			result *= 10;
			if (result < limit + digit)
				return false;
			result -= digit;
		}
		return true;
	}

	public static boolean notInt(String value) {
		return !isInt(value);
	}

	public static String ifIsIntGet(String value, String getValue) {
		return notInt(value) ? value : getValue;
	}

	public static String ifIsIntGet(String value, Supplier<String> getFun) {
		return notInt(value) ? value : getFun.get();
	}

	public static String ifIsIntGet(String value, IntFunction<String> getFun) {
		return notInt(value) ? value : getFun.apply(Integer.parseInt(value.trim()));
	}

	public static <R> R ifIsIntOrElseGet(String value, R getValue1, R getValue2) {
		return isInt(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsIntOrElseGet(String value, Supplier<R> getFun, R getValue) {
		return isInt(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsIntOrElseGet(String value, R getValue, Supplier<R> getFun) {
		return isInt(value) ? getValue : getFun.get();
	}

	public static <R> R ifIsIntOrElseGet(String value, IntFunction<R> getFun, R getValue) {
		return isInt(value) ? getFun.apply(Integer.parseInt(value.trim())) : getValue;
	}

	public static <R> R ifIsIntOrElseGet(String value, R getValue, Function<String, R> getFun) {
		return isInt(value) ? getValue : getFun.apply(value);
	}

	public static int ifNotIntGet(String value, int getValue) {
		return isInt(value) ? Integer.parseInt(value.trim()) : getValue;
	}

	public static int ifNotIntGet(String value, IntSupplier getFun) {
		return isInt(value) ? Integer.parseInt(value.trim()) : getFun.getAsInt();
	}

	public static int ifNotIntGet(String value, ToIntFunction<String> getFun) {
		return isInt(value) ? Integer.parseInt(value.trim()) : getFun.applyAsInt(value);
	}

	public static <R> R ifNotIntOrElseGet(String value, R getValue1, R getValue2) {
		return notInt(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotIntOrElseGet(String value, Supplier<R> getFun, R getValue) {
		return notInt(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotIntOrElseGet(String value, R getValue, Supplier<R> getFun) {
		return notInt(value) ? getValue : getFun.get();
	}

	public static <R> R ifNotIntOrElseGet(String value, Function<String, R> getFun, R getValue) {
		return notInt(value) ? getFun.apply(value) : getValue;
	}

	public static <R> R ifNotIntOrElseGet(String value, R getValue, IntFunction<R> getFun) {
		return notInt(value) ? getValue : getFun.apply(Integer.parseInt(value.trim()));
	}

	public static void ifIsInt(String value, VoidFunction fun) {
		if (isInt(value))
			fun.run();
	}

	public static void ifIsInt(String value, IntConsumer fun) {
		if (isInt(value))
			fun.accept(Integer.parseInt(value.trim()));
	}

	public static void ifNotInt(String value, VoidFunction fun) {
		if (notInt(value))
			fun.run();
	}

	public static void ifNotInt(String value, Consumer<String> fun) {
		if (notInt(value))
			fun.accept(value);
	}

	public static void ifIsIntOrElse(String value, VoidFunction fun1, VoidFunction fun2) {
		if (isInt(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsIntOrElse(String value, VoidFunction fun1, Consumer<String> fun2) {
		if (isInt(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifIsIntOrElse(String value, IntConsumer fun1, VoidFunction fun2) {
		if (isInt(value))
			fun1.accept(Integer.parseInt(value.trim()));
		else
			fun2.run();
	}

	public static void ifIsIntOrElse(String value, IntConsumer fun1, Consumer<String> fun2) {
		if (isInt(value))
			fun1.accept(Integer.parseInt(value.trim()));
		else
			fun2.accept(value);
	}

	public static void ifNotIntOrElse(String value, VoidFunction fun1, VoidFunction fun2) {
		if (notInt(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotIntOrElse(String value, Consumer<String> fun1, VoidFunction fun2) {
		if (notInt(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void ifNotIntOrElse(String value, VoidFunction fun1, IntConsumer fun2) {
		if (notInt(value))
			fun1.run();
		else
			fun2.accept(Integer.parseInt(value.trim()));
	}

	public static void ifNotIntOrElse(String value, Consumer<String> fun1, IntConsumer fun2) {
		if (notInt(value))
			fun1.accept(value);
		else
			fun2.accept(Integer.parseInt(value.trim()));
	}

	public static int isInt(String value, String message) throws CheckException {
		return isInt(value, new CheckException(message));
	}

	public static <Ex extends CheckException> int isInt(String value, Ex ex) throws Ex {
		if (notInt(value))
			throw ex;
		return Integer.parseInt(value.trim());
	}

	public static String notInt(String value, String message) throws CheckException {
		return notInt(value, new CheckException(message));
	}

	public static <Ex extends CheckException> String notInt(String value, Ex ex) throws Ex {
		if (isInt(value))
			throw ex;
		return value;
	}

	public static boolean isLong(String value) {
		if (isEmpty(value))
			return false;
		value = value.trim();
		long result = 0;
		int i = 0, len = value.length();
		long limit = -Long.MAX_VALUE;
		long multmin;
		int digit;
		if (len <= 0)
			return false;
		char firstChar = value.charAt(0);
		if (firstChar < '0') {
			if (firstChar == '-') {
				limit = Long.MIN_VALUE;
			} else if (firstChar != '+')
				return false;
			if (len == 1)
				return false;
			i++;
		}
		multmin = limit / 10;
		while (i < len) {
			digit = Character.digit(value.charAt(i++), 10);
			if (digit < 0)
				return false;
			if (result < multmin)
				return false;
			result *= 10;
			if (result < limit + digit)
				return false;
			result -= digit;
		}
		return true;
	}

	public static boolean notLong(String value) {
		return !isLong(value);
	}

	public static String ifIsLongGet(String value, String getValue) {
		return notLong(value) ? value : getValue;
	}

	public static String ifIsLongGet(String value, Supplier<String> getFun) {
		return notLong(value) ? value : getFun.get();
	}

	public static String ifIsLongGet(String value, LongFunction<String> getFun) {
		return notLong(value) ? value : getFun.apply(Long.parseLong(value.trim()));
	}

	public static <R> R ifIsLongOrElseGet(String value, R getValue1, R getValue2) {
		return isLong(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsLongOrElseGet(String value, Supplier<R> getFun, R getValue) {
		return isLong(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsLongOrElseGet(String value, R getValue, Supplier<R> getFun) {
		return isLong(value) ? getValue : getFun.get();
	}

	public static <R> R ifIsLongOrElseGet(String value, LongFunction<R> getFun, R getValue) {
		return isLong(value) ? getFun.apply(Long.parseLong(value.trim())) : getValue;
	}

	public static <R> R ifIsLongOrElseGet(String value, R getValue, Function<String, R> getFun) {
		return isLong(value) ? getValue : getFun.apply(value);
	}

	public static long ifNotLongGet(String value, long getValue) {
		return isLong(value) ? Long.parseLong(value.trim()) : getValue;
	}

	public static long ifNotLongGet(String value, LongSupplier getFun) {
		return isLong(value) ? Long.parseLong(value.trim()) : getFun.getAsLong();
	}

	public static long ifNotLongGet(String value, ToLongFunction<String> getFun) {
		return isLong(value) ? Long.parseLong(value.trim()) : getFun.applyAsLong(value);
	}

	public static <R> R ifNotLongOrElseGet(String value, R getValue1, R getValue2) {
		return notLong(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotLongOrElseGet(String value, Supplier<R> getFun, R getValue) {
		return notLong(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotLongOrElseGet(String value, R getValue, Supplier<R> getFun) {
		return notLong(value) ? getValue : getFun.get();
	}

	public static <R> R ifNotLongOrElseGet(String value, Function<String, R> getFun, R getValue) {
		return notLong(value) ? getFun.apply(value) : getValue;
	}

	public static <R> R ifNotLongOrElseGet(String value, R getValue, LongFunction<R> getFun) {
		return notLong(value) ? getValue : getFun.apply(Long.parseLong(value.trim()));
	}

	public static void ifIsLong(String value, VoidFunction fun) {
		if (isLong(value))
			fun.run();
	}

	public static void ifIsLong(String value, LongConsumer fun) {
		if (isLong(value))
			fun.accept(Long.parseLong(value.trim()));
	}

	public static void ifNotLong(String value, VoidFunction fun) {
		if (notLong(value))
			fun.run();
	}

	public static void ifNotLong(String value, Consumer<String> fun) {
		if (notLong(value))
			fun.accept(value);
	}

	public static void ifIsLongOrElse(String value, VoidFunction fun1, VoidFunction fun2) {
		if (isLong(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsLongOrElse(String value, VoidFunction fun1, Consumer<String> fun2) {
		if (isLong(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifIsLongOrElse(String value, LongConsumer fun1, VoidFunction fun2) {
		if (isLong(value))
			fun1.accept(Long.parseLong(value.trim()));
		else
			fun2.run();
	}

	public static void ifIsLongOrElse(String value, LongConsumer fun1, Consumer<String> fun2) {
		if (isLong(value))
			fun1.accept(Long.parseLong(value.trim()));
		else
			fun2.accept(value);
	}

	public static void ifNotLongOrElse(String value, VoidFunction fun1, VoidFunction fun2) {
		if (notLong(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotLongOrElse(String value, Consumer<String> fun1, VoidFunction fun2) {
		if (notLong(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void ifNotLongOrElse(String value, VoidFunction fun1, LongConsumer fun2) {
		if (notLong(value))
			fun1.run();
		else
			fun2.accept(Long.parseLong(value.trim()));
	}

	public static void ifNotLongOrElse(String value, Consumer<String> fun1, LongConsumer fun2) {
		if (notLong(value))
			fun1.accept(value);
		else
			fun2.accept(Long.parseLong(value.trim()));
	}

	public static long isLong(String value, String message) throws CheckException {
		return isLong(value, new CheckException(message));
	}

	public static <Ex extends CheckException> long isLong(String value, Ex ex) throws Ex {
		if (notLong(value))
			throw ex;
		return Long.parseLong(value);
	}

	public static String notLong(String value, String message) throws CheckException {
		return notLong(value, new CheckException(message));
	}

	public static <Ex extends CheckException> String notLong(String value, Ex ex) throws Ex {
		if (isLong(value))
			throw ex;
		return value;
	}

	public static boolean isBigDecimal(String value) {
		if (isEmpty(value))
			return false;
		value = value.trim();
		return isRegex(value, "[+\\-]?\\d+(\\.\\d+)?");
	}

	public static boolean notBigDecimal(String value) {
		return !isBigDecimal(value);
	}

	public static String ifIsBigDecimalGet(String value, String getValue) {
		return notBigDecimal(value) ? value : getValue;
	}

	public static String ifIsBigDecimalGet(String value, Supplier<String> getFun) {
		return notBigDecimal(value) ? value : getFun.get();
	}

	public static String ifIsBigDecimalGet(String value, Function<BigDecimal, String> getFun) {
		return notBigDecimal(value) ? value : getFun.apply(new BigDecimal(value.trim()));
	}

	public static <R> R ifIsBigDecimalOrElseGet(String value, R getValue1, R getValue2) {
		return isBigDecimal(value) ? getValue1 : getValue2;
	}

	public static <R> R ifIsBigDecimalOrElseGet(String value, Supplier<R> getFun, R getValue) {
		return isBigDecimal(value) ? getFun.get() : getValue;
	}

	public static <R> R ifIsBigDecimalOrElseGet(String value, R getValue, Supplier<R> getFun) {
		return isBigDecimal(value) ? getValue : getFun.get();
	}

	public static <R> R ifIsBigDecimalOrElseGet(String value, Function<BigDecimal, R> getFun, R getValue) {
		return isBigDecimal(value) ? getFun.apply(new BigDecimal(value.trim())) : getValue;
	}

	public static <R> R ifIsBigDecimalOrElseGet(String value, R getValue, Function<String, R> getFun) {
		return isBigDecimal(value) ? getValue : getFun.apply(value);
	}

	public static BigDecimal ifNotBigDecimalGet(String value, BigDecimal getValue) {
		return isBigDecimal(value) ? new BigDecimal(value.trim()) : getValue;
	}

	public static BigDecimal ifNotBigDecimalGet(String value, Supplier<BigDecimal> getFun) {
		return isBigDecimal(value) ? new BigDecimal(value.trim()) : getFun.get();
	}

	public static BigDecimal ifNotBigDecimalGet(String value, Function<String, BigDecimal> getFun) {
		return isBigDecimal(value) ? new BigDecimal(value.trim()) : getFun.apply(value);
	}

	public static <R> R ifNotBigDecimalOrElseGet(String value, R getValue1, R getValue2) {
		return notBigDecimal(value) ? getValue1 : getValue2;
	}

	public static <R> R ifNotBigDecimalOrElseGet(String value, Supplier<R> getFun, R getValue) {
		return notBigDecimal(value) ? getFun.get() : getValue;
	}

	public static <R> R ifNotBigDecimalOrElseGet(String value, R getValue, Supplier<R> getFun) {
		return notBigDecimal(value) ? getValue : getFun.get();
	}

	public static <R> R ifNotBigDecimalOrElseGet(String value, Function<String, R> getFun, R getValue) {
		return notBigDecimal(value) ? getFun.apply(value) : getValue;
	}

	public static <R> R ifNotBigDecimalOrElseGet(String value, R getValue, Function<BigDecimal, R> getFun) {
		return notBigDecimal(value) ? getValue : getFun.apply(new BigDecimal(value.trim()));
	}

	public static void ifIsBigDecimal(String value, VoidFunction fun) {
		if (isBigDecimal(value))
			fun.run();
	}

	public static void ifIsBigDecimal(String value, Consumer<BigDecimal> fun) {
		if (isBigDecimal(value))
			fun.accept(new BigDecimal(value.trim()));
	}

	public static void ifNotBigDecimal(String value, VoidFunction fun) {
		if (notBigDecimal(value))
			fun.run();
	}

	public static void ifNotBigDecimal(String value, Consumer<String> fun) {
		if (notBigDecimal(value))
			fun.accept(value);
	}

	public static void ifIsBigDecimalOrElse(String value, VoidFunction fun1, VoidFunction fun2) {
		if (isBigDecimal(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsBigDecimalOrElse(String value, VoidFunction fun1, Consumer<String> fun2) {
		if (isBigDecimal(value))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifIsBigDecimalOrElse(String value, Consumer<BigDecimal> fun1, VoidFunction fun2) {
		if (isBigDecimal(value))
			fun1.accept(new BigDecimal(value.trim()));
		else
			fun2.run();
	}

	public static void ifIsBigDecimalOrElse(String value, Consumer<BigDecimal> fun1, Consumer<String> fun2) {
		if (isBigDecimal(value))
			fun1.accept(new BigDecimal(value.trim()));
		else
			fun2.accept(value);
	}

	public static void ifNotBigDecimalOrElse(String value, VoidFunction fun1, VoidFunction fun2) {
		if (notBigDecimal(value))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotBigDecimalOrElse(String value, Consumer<String> fun1, VoidFunction fun2) {
		if (notBigDecimal(value))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void ifNotBigDecimalOrElse(String value, VoidFunction fun1, Consumer<BigDecimal> fun2) {
		if (notBigDecimal(value))
			fun1.run();
		else
			fun2.accept(new BigDecimal(value.trim()));
	}

	public static void ifNotBigDecimalOrElse(String value, Consumer<String> fun1, Consumer<BigDecimal> fun2) {
		if (notBigDecimal(value))
			fun1.accept(value);
		else
			fun2.accept(new BigDecimal(value.trim()));
	}

	public static BigDecimal isBigDecimal(String value, String message) throws CheckException {
		return isBigDecimal(value, new CheckException(message));
	}

	public static <Ex extends CheckException> BigDecimal isBigDecimal(String value, Ex ex) throws Ex {
		if (notBigDecimal(value))
			throw ex;
		return new BigDecimal(value);
	}

	public static String notBigDecimal(String value, String message) throws CheckException {
		return notBigDecimal(value, new CheckException(message));
	}

	public static <Ex extends CheckException> String notBigDecimal(String value, Ex ex) throws Ex {
		if (isBigDecimal(value))
			throw ex;
		return value;
	}

	public static boolean isStartsWith(String value, String prefix) {
		return notNull(value) && notNull(prefix) && value.startsWith(prefix);
	}

	public static boolean notStartsWith(String value, String prefix) {
		return !isStartsWith(value, prefix);
	}

	public static String ifIsStartsWithGet(String value, String prefix, String getValue) {
		return notStartsWith(value, prefix) ? value : getValue;
	}

	public static String ifIsStartsWithGet(String value, String prefix, Supplier<String> getFun) {
		return notStartsWith(value, prefix) ? value : getFun.get();
	}

	public static String ifIsStartsWithGet(String value, String prefix, Function<String, String> getFun) {
		return notStartsWith(value, prefix) ? value : getFun.apply(value);
	}

	public static <R> R ifIsStartsWithOrElseGet(String value, String prefix, R getValue1, R getValue2) {
		return isStartsWith(value, prefix) ? getValue1 : getValue2;
	}

	public static <R> R ifIsStartsWithOrElseGet(String value, String prefix, Supplier<R> getFun, R getValue) {
		return isStartsWith(value, prefix) ? getFun.get() : getValue;
	}

	public static <R> R ifIsStartsWithOrElseGet(String value, String prefix, R getValue, Supplier<R> getFun) {
		return isStartsWith(value, prefix) ? getValue : getFun.get();
	}

	public static <R> R ifIsStartsWithOrElseGet(String value, String prefix, Function<String, R> getFun, R getValue) {
		return isStartsWith(value, prefix) ? getFun.apply(value) : getValue;
	}

	public static <R> R ifIsStartsWithOrElseGet(String value, String prefix, R getValue, Function<String, R> getFun) {
		return isStartsWith(value, prefix) ? getValue : getFun.apply(value);
	}

	public static String ifNotStartsWithGet(String value, String prefix, String getValue) {
		return isStartsWith(value, prefix) ? value : getValue;
	}

	public static String ifNotStartsWithGet(String value, String prefix, Supplier<String> getFun) {
		return isStartsWith(value, prefix) ? value : getFun.get();
	}

	public static String ifNotStartsWithGet(String value, String prefix, Function<String, String> getFun) {
		return isStartsWith(value, prefix) ? value : getFun.apply(value);
	}

	public static <R> R ifNotStartsWithOrElseGet(String value, String prefix, R getValue1, R getValue2) {
		return notStartsWith(value, prefix) ? getValue1 : getValue2;
	}

	public static <R> R ifNotStartsWithOrElseGet(String value, String prefix, Supplier<R> getFun, R getValue) {
		return notStartsWith(value, prefix) ? getFun.get() : getValue;
	}

	public static <R> R ifNotStartsWithOrElseGet(String value, String prefix, R getValue, Supplier<R> getFun) {
		return notStartsWith(value, prefix) ? getValue : getFun.get();
	}

	public static <R> R ifNotStartsWithOrElseGet(String value, String prefix, Function<String, R> getFun, R getValue) {
		return notStartsWith(value, prefix) ? getFun.apply(value) : getValue;
	}

	public static <R> R ifNotStartsWithOrElseGet(String value, String prefix, R getValue, Function<String, R> getFun) {
		return notStartsWith(value, prefix) ? getValue : getFun.apply(value);
	}

	public static void ifIsStartsWith(String value, String prefix, VoidFunction fun) {
		if (isStartsWith(value, prefix))
			fun.run();
	}

	public static void ifIsStartsWith(String value, String prefix, Consumer<String> fun) {
		if (isStartsWith(value, prefix))
			fun.accept(value);
	}

	public static void ifNotStartsWith(String value, String prefix, VoidFunction fun) {
		if (notStartsWith(value, prefix))
			fun.run();
	}

	public static void ifNotStartsWith(String value, String prefix, Consumer<String> fun) {
		if (notStartsWith(value, prefix))
			fun.accept(value);
	}

	public static void ifIsStartsWithOrElse(String value, String prefix, VoidFunction fun1, VoidFunction fun2) {
		if (isStartsWith(value, prefix))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsStartsWithOrElse(String value, String prefix, VoidFunction fun1, Consumer<String> fun2) {
		if (isStartsWith(value, prefix))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifIsStartsWithOrElse(String value, String prefix, Consumer<String> fun1, VoidFunction fun2) {
		if (isStartsWith(value, prefix))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void ifIsStartsWithOrElse(String value, String prefix, Consumer<String> fun1, Consumer<String> fun2) {
		if (isStartsWith(value, prefix))
			fun1.accept(value);
		else
			fun2.accept(value);
	}

	public static void ifNotStartsWithOrElse(String value, String prefix, VoidFunction fun1, VoidFunction fun2) {
		if (notStartsWith(value, prefix))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotStartsWithOrElse(String value, String prefix, Consumer<String> fun1, VoidFunction fun2) {
		if (notStartsWith(value, prefix))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void ifNotStartsWithOrElse(String value, String prefix, VoidFunction fun1, Consumer<String> fun2) {
		if (notStartsWith(value, prefix))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotStartsWithOrElse(String value, String prefix, Consumer<String> fun1,
			Consumer<String> fun2) {
		if (notStartsWith(value, prefix))
			fun1.accept(value);
		else
			fun2.accept(value);
	}

	public static String isStartsWith(String value, String prefix, String message) throws CheckException {
		return isStartsWith(value, prefix, new CheckException(message));
	}

	public static <Ex extends CheckException> String isStartsWith(String value, String prefix, Ex ex) throws Ex {
		if (notStartsWith(value, prefix))
			throw ex;
		return value;
	}

	public static String notStartsWith(String value, String prefix, String message) throws CheckException {
		return notStartsWith(value, prefix, new CheckException(message));
	}

	public static <Ex extends CheckException> String notStartsWith(String value, String prefix, Ex ex) throws Ex {
		if (isStartsWith(value, prefix))
			throw ex;
		return value;
	}

	public static boolean isEndsWith(String value, String suffix) {
		return notNull(value) && notNull(suffix) && value.endsWith(suffix);
	}

	public static boolean notEndsWith(String value, String prefix) {
		return !isEndsWith(value, prefix);
	}

	public static String ifIsEndsWithGet(String value, String prefix, String getValue) {
		return notEndsWith(value, prefix) ? value : getValue;
	}

	public static String ifIsEndsWithGet(String value, String prefix, Supplier<String> getFun) {
		return notEndsWith(value, prefix) ? value : getFun.get();
	}

	public static String ifIsEndsWithGet(String value, String prefix, Function<String, String> getFun) {
		return notEndsWith(value, prefix) ? value : getFun.apply(value);
	}

	public static <R> R ifIsEndsWithOrElseGet(String value, String prefix, R getValue1, R getValue2) {
		return isEndsWith(value, prefix) ? getValue1 : getValue2;
	}

	public static <R> R ifIsEndsWithOrElseGet(String value, String prefix, Supplier<R> getFun, R getValue) {
		return isEndsWith(value, prefix) ? getFun.get() : getValue;
	}

	public static <R> R ifIsEndsWithOrElseGet(String value, String prefix, R getValue, Supplier<R> getFun) {
		return isEndsWith(value, prefix) ? getValue : getFun.get();
	}

	public static <R> R ifIsEndsWithOrElseGet(String value, String prefix, Function<String, R> getFun, R getValue) {
		return isEndsWith(value, prefix) ? getFun.apply(value) : getValue;
	}

	public static <R> R ifIsEndsWithOrElseGet(String value, String prefix, R getValue, Function<String, R> getFun) {
		return isEndsWith(value, prefix) ? getValue : getFun.apply(value);
	}

	public static String ifNotEndsWithGet(String value, String prefix, String getValue) {
		return isEndsWith(value, prefix) ? value : getValue;
	}

	public static String ifNotEndsWithGet(String value, String prefix, Supplier<String> getFun) {
		return isEndsWith(value, prefix) ? value : getFun.get();
	}

	public static String ifNotEndsWithGet(String value, String prefix, Function<String, String> getFun) {
		return isEndsWith(value, prefix) ? value : getFun.apply(value);
	}

	public static <R> R ifNotEndsWithOrElseGet(String value, String prefix, R getValue1, R getValue2) {
		return notEndsWith(value, prefix) ? getValue1 : getValue2;
	}

	public static <R> R ifNotEndsWithOrElseGet(String value, String prefix, Supplier<R> getFun, R getValue) {
		return notEndsWith(value, prefix) ? getFun.get() : getValue;
	}

	public static <R> R ifNotEndsWithOrElseGet(String value, String prefix, R getValue, Supplier<R> getFun) {
		return notEndsWith(value, prefix) ? getValue : getFun.get();
	}

	public static <R> R ifNotEndsWithOrElseGet(String value, String prefix, Function<String, R> getFun, R getValue) {
		return notEndsWith(value, prefix) ? getFun.apply(value) : getValue;
	}

	public static <R> R ifNotEndsWithOrElseGet(String value, String prefix, R getValue, Function<String, R> getFun) {
		return notEndsWith(value, prefix) ? getValue : getFun.apply(value);
	}

	public static void ifIsEndsWith(String value, String prefix, VoidFunction fun) {
		if (isEndsWith(value, prefix))
			fun.run();
	}

	public static void ifIsEndsWith(String value, String prefix, Consumer<String> fun) {
		if (isEndsWith(value, prefix))
			fun.accept(value);
	}

	public static void ifNotEndsWith(String value, String prefix, VoidFunction fun) {
		if (notEndsWith(value, prefix))
			fun.run();
	}

	public static void ifNotEndsWith(String value, String prefix, Consumer<String> fun) {
		if (notEndsWith(value, prefix))
			fun.accept(value);
	}

	public static void ifIsEndsWithOrElse(String value, String prefix, VoidFunction fun1, VoidFunction fun2) {
		if (isEndsWith(value, prefix))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifIsEndsWithOrElse(String value, String prefix, VoidFunction fun1, Consumer<String> fun2) {
		if (isEndsWith(value, prefix))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifIsEndsWithOrElse(String value, String prefix, Consumer<String> fun1, VoidFunction fun2) {
		if (isEndsWith(value, prefix))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void ifIsEndsWithOrElse(String value, String prefix, Consumer<String> fun1, Consumer<String> fun2) {
		if (isEndsWith(value, prefix))
			fun1.accept(value);
		else
			fun2.accept(value);
	}

	public static void ifNotEndsWithOrElse(String value, String prefix, VoidFunction fun1, VoidFunction fun2) {
		if (notEndsWith(value, prefix))
			fun1.run();
		else
			fun2.run();
	}

	public static void ifNotEndsWithOrElse(String value, String prefix, Consumer<String> fun1, VoidFunction fun2) {
		if (notEndsWith(value, prefix))
			fun1.accept(value);
		else
			fun2.run();
	}

	public static void ifNotEndsWithOrElse(String value, String prefix, VoidFunction fun1, Consumer<String> fun2) {
		if (notEndsWith(value, prefix))
			fun1.run();
		else
			fun2.accept(value);
	}

	public static void ifNotEndsWithOrElse(String value, String prefix, Consumer<String> fun1, Consumer<String> fun2) {
		if (notEndsWith(value, prefix))
			fun1.accept(value);
		else
			fun2.accept(value);
	}

	public static String isEndsWith(String value, String suffix, String message) throws CheckException {
		return isEndsWith(value, suffix, new CheckException(message));
	}

	public static <Ex extends CheckException> String isEndsWith(String value, String suffix, Ex ex) throws Ex {
		if (notEndsWith(value, suffix))
			throw ex;
		return value;
	}

	public static String notEndsWith(String value, String suffix, String message) throws CheckException {
		return notEndsWith(value, suffix, new CheckException(message));
	}

	public static <Ex extends CheckException> String notEndsWith(String value, String suffix, Ex ex) throws Ex {
		if (isEndsWith(value, suffix))
			throw ex;
		return value;
	}
}