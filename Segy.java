// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.nio.charset.Charset;

public class Segy extends KaitaiStruct {
    public static Segy fromFile(String fileName) throws IOException {
        return new Segy(new ByteBufferKaitaiStream(fileName));
    }

    public enum FormatCodes {
        R4IBM(1),
        S4(2),
        S2(3),
        OBSOLETE(4),
        F4(5),
        F8(6),
        S3(7),
        S1(8),
        S8(9),
        U4(10),
        U2(11),
        U8(12),
        U3(15),
        U1(16);

        private final long id;
        FormatCodes(long id) { this.id = id; }
        public long id() { return id; }
        private static final Map<Long, FormatCodes> byId = new HashMap<Long, FormatCodes>(14);
        static {
            for (FormatCodes e : FormatCodes.values())
                byId.put(e.id(), e);
        }
        public static FormatCodes byId(long id) { return byId.get(id); }
    }

    public Segy(KaitaiStream _io) {
        this(_io, null, null);
    }

    public Segy(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public Segy(KaitaiStream _io, KaitaiStruct _parent, Segy _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.txt = new TextHeader(this._io, this, _root);
        this.binary = new BinaryHeader(this._io, this, _root);
        this.traces = new ArrayList<Trace>();
        {
            int i = 0;
            while (!this._io.isEof()) {
                this.traces.add(new Trace(this._io, this, _root));
                i++;
            }
        }
    }
    public static class S3 extends KaitaiStruct {
        public static S3 fromFile(String fileName) throws IOException {
            return new S3(new ByteBufferKaitaiStream(fileName));
        }

        public S3(KaitaiStream _io) {
            this(_io, null, null);
        }

        public S3(KaitaiStream _io, Segy.TraceData _parent) {
            this(_io, _parent, null);
        }

        public S3(KaitaiStream _io, Segy.TraceData _parent, Segy _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.val = this._io.readBytes(3);
        }
        private byte[] val;
        private Segy _root;
        private Segy.TraceData _parent;
        public byte[] val() { return val; }
        public Segy _root() { return _root; }
        public Segy.TraceData _parent() { return _parent; }
    }
    public static class Trace extends KaitaiStruct {
        public static Trace fromFile(String fileName) throws IOException {
            return new Trace(new ByteBufferKaitaiStream(fileName));
        }
        private Boolean _is_le;

        public Trace(KaitaiStream _io) {
            this(_io, null, null);
        }

        public Trace(KaitaiStream _io, Segy _parent) {
            this(_io, _parent, null);
        }

        public Trace(KaitaiStream _io, Segy _parent, Segy _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            {
                FormatCodes on = _root().binary().formatCode();
                if (on != null) {
                    switch (_root().binary().formatCode()) {
                    case new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }: {
                        boolean _tmp = (boolean) (true);
                        this._is_le = _tmp;
                        break;
                    }
                    default: {
                        boolean _tmp = (boolean) (false);
                        this._is_le = _tmp;
                        break;
                    }
                    }
                } else {
                    boolean _tmp = (boolean) (false);
                    this._is_le = _tmp;
                }
            }

            if (_is_le == null) {
                throw new KaitaiStream.UndecidedEndiannessError();
            } else if (_is_le) {
                _readLE();
            } else {
                _readBE();
            }
        }
        private void _readLE() {
            this.header = new TraceHeader(this._io, this, _root);
            this.data = new TraceData(this._io, this, _root);
        }
        private void _readBE() {
            this.header = new TraceHeader(this._io, this, _root);
            this.data = new TraceData(this._io, this, _root);
        }
        private TraceHeader header;
        private TraceData data;
        private Segy _root;
        private Segy _parent;
        public TraceHeader header() { return header; }
        public TraceData data() { return data; }
        public Segy _root() { return _root; }
        public Segy _parent() { return _parent; }
    }
    public static class TraceData extends KaitaiStruct {
        public static TraceData fromFile(String fileName) throws IOException {
            return new TraceData(new ByteBufferKaitaiStream(fileName));
        }

        public TraceData(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TraceData(KaitaiStream _io, Segy.Trace _parent) {
            this(_io, _parent, null);
        }

        public TraceData(KaitaiStream _io, Segy.Trace _parent, Segy _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.samples = new ArrayList<Object>();
            for (int i = 0; i < _root().binary().nSamples(); i++) {
                {
                    FormatCodes on = _root().binary().formatCode();
                    if (on != null) {
                        switch (_root().binary().formatCode()) {
                        case S1: {
                            this.samples.add((Object) (this._io.readS1()));
                            break;
                        }
                        case R4IBM: {
                            this.samples.add((Object) (this._io.readF4be()));
                            break;
                        }
                        case U8: {
                            this.samples.add((Object) (this._io.readU8be()));
                            break;
                        }
                        case U2: {
                            this.samples.add((Object) (this._io.readU2be()));
                            break;
                        }
                        case F4: {
                            this.samples.add((Object) (this._io.readF4be()));
                            break;
                        }
                        case S8: {
                            this.samples.add((Object) (this._io.readS8be()));
                            break;
                        }
                        case OBSOLETE: {
                            this.samples.add((Object) (this._io.readF4be()));
                            break;
                        }
                        case S2: {
                            this.samples.add((Object) (this._io.readS2be()));
                            break;
                        }
                        case U3: {
                            this.samples.add(new U3(this._io, this, _root));
                            break;
                        }
                        case U4: {
                            this.samples.add((Object) (this._io.readU4be()));
                            break;
                        }
                        case U1: {
                            this.samples.add((Object) (this._io.readU1()));
                            break;
                        }
                        case S3: {
                            this.samples.add(new S3(this._io, this, _root));
                            break;
                        }
                        case S4: {
                            this.samples.add((Object) (this._io.readS4be()));
                            break;
                        }
                        case F8: {
                            this.samples.add((Object) (this._io.readF8be()));
                            break;
                        }
                        }
                    }
                }
            }
        }
        private ArrayList<Object> samples;
        private Segy _root;
        private Segy.Trace _parent;
        public ArrayList<Object> samples() { return samples; }
        public Segy _root() { return _root; }
        public Segy.Trace _parent() { return _parent; }
    }
    public static class TextHeader extends KaitaiStruct {
        public static TextHeader fromFile(String fileName) throws IOException {
            return new TextHeader(new ByteBufferKaitaiStream(fileName));
        }

        public TextHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TextHeader(KaitaiStream _io, Segy _parent) {
            this(_io, _parent, null);
        }

        public TextHeader(KaitaiStream _io, Segy _parent, Segy _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.text = new String(this._io.readBytes(3200), Charset.forName("UTF-8"));
        }
        private String text;
        private Segy _root;
        private Segy _parent;
        public String text() { return text; }
        public Segy _root() { return _root; }
        public Segy _parent() { return _parent; }
    }
    public static class U3 extends KaitaiStruct {
        public static U3 fromFile(String fileName) throws IOException {
            return new U3(new ByteBufferKaitaiStream(fileName));
        }

        public U3(KaitaiStream _io) {
            this(_io, null, null);
        }

        public U3(KaitaiStream _io, Segy.TraceData _parent) {
            this(_io, _parent, null);
        }

        public U3(KaitaiStream _io, Segy.TraceData _parent, Segy _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.val = this._io.readBytes(3);
        }
        private byte[] val;
        private Segy _root;
        private Segy.TraceData _parent;
        public byte[] val() { return val; }
        public Segy _root() { return _root; }
        public Segy.TraceData _parent() { return _parent; }
    }
    public static class BinaryHeader extends KaitaiStruct {
        public static BinaryHeader fromFile(String fileName) throws IOException {
            return new BinaryHeader(new ByteBufferKaitaiStream(fileName));
        }
        private Boolean _is_le;

        public BinaryHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public BinaryHeader(KaitaiStream _io, Segy _parent) {
            this(_io, _parent, null);
        }

        public BinaryHeader(KaitaiStream _io, Segy _parent, Segy _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            {
                FormatCodes on = formatCode();
                if (on != null) {
                    switch (formatCode()) {
                    case new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }: {
                        boolean _tmp = (boolean) (true);
                        this._is_le = _tmp;
                        break;
                    }
                    default: {
                        boolean _tmp = (boolean) (false);
                        this._is_le = _tmp;
                        break;
                    }
                    }
                } else {
                    boolean _tmp = (boolean) (false);
                    this._is_le = _tmp;
                }
            }

            if (_is_le == null) {
                throw new KaitaiStream.UndecidedEndiannessError();
            } else if (_is_le) {
                _readLE();
            } else {
                _readBE();
            }
        }
        private void _readLE() {
            this.jid = this._io.readU4le();
            this.lineno = this._io.readU4le();
            this.reelno = this._io.readU4le();
            this.nTrEns = this._io.readU2le();
            this.nTrAux = this._io.readU2le();
            this.dt = this._io.readU2le();
            this.dtField = this._io.readU2le();
            this.nSamples = this._io.readU2le();
            this.nSamplesField = this._io.readU2le();
            this.formatCode = Segy.FormatCodes.byId(this._io.readU2le());
            this.fold = this._io.readU2le();
            this.sortingCode = this._io.readU2le();
            this.verticalSumCode = this._io.readU2le();
            this.sweepStart = this._io.readU2le();
            this.sweepEnd = this._io.readU2le();
            this.sweepLength = this._io.readU2le();
            this.sweepTypeCode = this._io.readU2le();
            this.sweepChannel = this._io.readU2le();
            this.sweepTaperStart = this._io.readU2le();
            this.sweepTaperEnd = this._io.readU2le();
            this.taperType = this._io.readU2le();
            this.correlatedDataTraces = this._io.readU2le();
            this.binaryGainRecovered = this._io.readU2le();
            this.ampRecoveryMethod = this._io.readU2le();
            this.measurementSystem = this._io.readU2le();
            this.signalPolarity = this._io.readU2le();
            this.polarityCode = this._io.readU2le();
            this.extNTracesEns = this._io.readU4le();
            this.extNTrAux = this._io.readU4le();
            this.extNSamples = this._io.readU4le();
            this.extDt = this._io.readF8le();
            this.extDtField = this._io.readF8le();
            this.extNSamplesField = this._io.readU4le();
            this.extFold = this._io.readU4le();
            this.orderingConstant = this._io.readU4le();
            if (!( ((orderingConstant() == 0) || (orderingConstant() == 67305985) || (orderingConstant() == 33620995)) )) {
                throw new KaitaiStream.ValidationNotAnyOfError(orderingConstant(), _io(), "/types/binary_header/seq/34");
            }
            this.unassigned1 = this._io.readBytes(200);
            this.majorRev = this._io.readU1();
            this.minorRev = this._io.readU1();
            this.fixedLenFlag = this._io.readU2le();
            this.extTxtNum = this._io.readU2le();
            this.maxTrhNum = this._io.readU4le();
            this.timeBasisCode = this._io.readU2le();
            this.numTracesStream = this._io.readU8le();
            this.fTraceOffset = this._io.readU8le();
            this.numStanza = this._io.readU4le();
            this.unassigned2 = this._io.readBytes(68);
        }
        private void _readBE() {
            this.jid = this._io.readU4be();
            this.lineno = this._io.readU4be();
            this.reelno = this._io.readU4be();
            this.nTrEns = this._io.readU2be();
            this.nTrAux = this._io.readU2be();
            this.dt = this._io.readU2be();
            this.dtField = this._io.readU2be();
            this.nSamples = this._io.readU2be();
            this.nSamplesField = this._io.readU2be();
            this.formatCode = Segy.FormatCodes.byId(this._io.readU2be());
            this.fold = this._io.readU2be();
            this.sortingCode = this._io.readU2be();
            this.verticalSumCode = this._io.readU2be();
            this.sweepStart = this._io.readU2be();
            this.sweepEnd = this._io.readU2be();
            this.sweepLength = this._io.readU2be();
            this.sweepTypeCode = this._io.readU2be();
            this.sweepChannel = this._io.readU2be();
            this.sweepTaperStart = this._io.readU2be();
            this.sweepTaperEnd = this._io.readU2be();
            this.taperType = this._io.readU2be();
            this.correlatedDataTraces = this._io.readU2be();
            this.binaryGainRecovered = this._io.readU2be();
            this.ampRecoveryMethod = this._io.readU2be();
            this.measurementSystem = this._io.readU2be();
            this.signalPolarity = this._io.readU2be();
            this.polarityCode = this._io.readU2be();
            this.extNTracesEns = this._io.readU4be();
            this.extNTrAux = this._io.readU4be();
            this.extNSamples = this._io.readU4be();
            this.extDt = this._io.readF8be();
            this.extDtField = this._io.readF8be();
            this.extNSamplesField = this._io.readU4be();
            this.extFold = this._io.readU4be();
            this.orderingConstant = this._io.readU4be();
            if (!( ((orderingConstant() == 0) || (orderingConstant() == 67305985) || (orderingConstant() == 33620995)) )) {
                throw new KaitaiStream.ValidationNotAnyOfError(orderingConstant(), _io(), "/types/binary_header/seq/34");
            }
            this.unassigned1 = this._io.readBytes(200);
            this.majorRev = this._io.readU1();
            this.minorRev = this._io.readU1();
            this.fixedLenFlag = this._io.readU2be();
            this.extTxtNum = this._io.readU2be();
            this.maxTrhNum = this._io.readU4be();
            this.timeBasisCode = this._io.readU2be();
            this.numTracesStream = this._io.readU8be();
            this.fTraceOffset = this._io.readU8be();
            this.numStanza = this._io.readU4be();
            this.unassigned2 = this._io.readBytes(68);
        }
        private long jid;
        private long lineno;
        private long reelno;
        private int nTrEns;
        private int nTrAux;
        private int dt;
        private int dtField;
        private int nSamples;
        private int nSamplesField;
        private FormatCodes formatCode;
        private int fold;
        private int sortingCode;
        private int verticalSumCode;
        private int sweepStart;
        private int sweepEnd;
        private int sweepLength;
        private int sweepTypeCode;
        private int sweepChannel;
        private int sweepTaperStart;
        private int sweepTaperEnd;
        private int taperType;
        private int correlatedDataTraces;
        private int binaryGainRecovered;
        private int ampRecoveryMethod;
        private int measurementSystem;
        private int signalPolarity;
        private int polarityCode;
        private long extNTracesEns;
        private long extNTrAux;
        private long extNSamples;
        private double extDt;
        private double extDtField;
        private long extNSamplesField;
        private long extFold;
        private long orderingConstant;
        private byte[] unassigned1;
        private int majorRev;
        private int minorRev;
        private int fixedLenFlag;
        private int extTxtNum;
        private long maxTrhNum;
        private int timeBasisCode;
        private long numTracesStream;
        private long fTraceOffset;
        private long numStanza;
        private byte[] unassigned2;
        private Segy _root;
        private Segy _parent;
        public long jid() { return jid; }
        public long lineno() { return lineno; }
        public long reelno() { return reelno; }
        public int nTrEns() { return nTrEns; }
        public int nTrAux() { return nTrAux; }
        public int dt() { return dt; }
        public int dtField() { return dtField; }
        public int nSamples() { return nSamples; }
        public int nSamplesField() { return nSamplesField; }
        public FormatCodes formatCode() { return formatCode; }
        public int fold() { return fold; }
        public int sortingCode() { return sortingCode; }
        public int verticalSumCode() { return verticalSumCode; }
        public int sweepStart() { return sweepStart; }
        public int sweepEnd() { return sweepEnd; }
        public int sweepLength() { return sweepLength; }
        public int sweepTypeCode() { return sweepTypeCode; }
        public int sweepChannel() { return sweepChannel; }
        public int sweepTaperStart() { return sweepTaperStart; }
        public int sweepTaperEnd() { return sweepTaperEnd; }
        public int taperType() { return taperType; }
        public int correlatedDataTraces() { return correlatedDataTraces; }
        public int binaryGainRecovered() { return binaryGainRecovered; }
        public int ampRecoveryMethod() { return ampRecoveryMethod; }
        public int measurementSystem() { return measurementSystem; }
        public int signalPolarity() { return signalPolarity; }
        public int polarityCode() { return polarityCode; }
        public long extNTracesEns() { return extNTracesEns; }
        public long extNTrAux() { return extNTrAux; }
        public long extNSamples() { return extNSamples; }
        public double extDt() { return extDt; }
        public double extDtField() { return extDtField; }
        public long extNSamplesField() { return extNSamplesField; }
        public long extFold() { return extFold; }
        public long orderingConstant() { return orderingConstant; }
        public byte[] unassigned1() { return unassigned1; }
        public int majorRev() { return majorRev; }
        public int minorRev() { return minorRev; }
        public int fixedLenFlag() { return fixedLenFlag; }
        public int extTxtNum() { return extTxtNum; }
        public long maxTrhNum() { return maxTrhNum; }
        public int timeBasisCode() { return timeBasisCode; }
        public long numTracesStream() { return numTracesStream; }
        public long fTraceOffset() { return fTraceOffset; }
        public long numStanza() { return numStanza; }
        public byte[] unassigned2() { return unassigned2; }
        public Segy _root() { return _root; }
        public Segy _parent() { return _parent; }
    }
    public static class TraceHeader extends KaitaiStruct {
        public static TraceHeader fromFile(String fileName) throws IOException {
            return new TraceHeader(new ByteBufferKaitaiStream(fileName));
        }

        public TraceHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TraceHeader(KaitaiStream _io, Segy.Trace _parent) {
            this(_io, _parent, null);
        }

        public TraceHeader(KaitaiStream _io, Segy.Trace _parent, Segy _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.traceSeqNumLine = this._io.readS4be();
            this.traceSeqNumReel = this._io.readS4be();
            this.ffid = this._io.readS4be();
            this.traceno = this._io.readS4be();
            this.source = this._io.readS4be();
            this.cdp = this._io.readS4be();
            this.tracenoEns1 = this._io.readS4be();
            this.idCode = this._io.readS2be();
            this.stckcntV = this._io.readS2be();
            this.stckcntH = this._io.readS2be();
            this.dataUse = this._io.readS2be();
            this.offset = this._io.readS4be();
            this.recElev = this._io.readS4be();
            this.souElev = this._io.readS4be();
            this.depth = this._io.readS4be();
            this.recDatum = this._io.readS4be();
            this.souDatum = this._io.readS4be();
            this.souH2o = this._io.readS4be();
            this.recH2o = this._io.readS4be();
            this.scalerElevs = this._io.readS2be();
            this.scalerCords = this._io.readS2be();
            this.souX = this._io.readS4be();
            this.souY = this._io.readS4be();
            this.recX = this._io.readS4be();
            this.recY = this._io.readS4be();
            this.units = this._io.readS2be();
            this.weatheringVelocity = this._io.readS2be();
            this.subweatheringVelocity = this._io.readS2be();
            this.upholeTimeSou = this._io.readS2be();
            this.upholeTimeRec = this._io.readS2be();
            this.souStat = this._io.readS2be();
            this.recStat = this._io.readS2be();
            this.totalStat = this._io.readS2be();
            this.lagA = this._io.readS2be();
            this.lagB = this._io.readS2be();
            this.delay = this._io.readS2be();
            this.muteTimeStart = this._io.readS2be();
            this.muteTimeEnd = this._io.readS2be();
            this.nSamplesCurrent = this._io.readS2be();
            this.dtCurrent = this._io.readS2be();
            this.gainType = this._io.readS2be();
            this.instrumentGain = this._io.readS2be();
            this.earlyGain = this._io.readS2be();
            this.correlated = this._io.readS2be();
            this.sweepStart = this._io.readS2be();
            this.sweepEnd = this._io.readS2be();
            this.sweepLength = this._io.readS2be();
            this.sweepType = this._io.readS2be();
            this.sweepTaperStart = this._io.readS2be();
            this.sweepTaperEnd = this._io.readS2be();
            this.taperType = this._io.readS2be();
            this.aliasFreq = this._io.readS2be();
            this.aliasSlope = this._io.readS2be();
            this.notchFreq = this._io.readS2be();
            this.notchSlope = this._io.readS2be();
            this.lowcutFreq = this._io.readS2be();
            this.highcutFreq = this._io.readS2be();
            this.lowcutSlope = this._io.readS2be();
            this.highcutSlope = this._io.readS2be();
            this.year = this._io.readS2be();
            this.day = this._io.readS2be();
            this.hour = this._io.readS2be();
            this.minute = this._io.readS2be();
            this.second = this._io.readS2be();
            this.timeBasisCode = this._io.readS2be();
            this.traceWeightFactor = this._io.readS2be();
            this.groupnoRoll = this._io.readS2be();
            this.groupnoFirstField = this._io.readS2be();
            this.groupnoLastField = this._io.readS2be();
            this.gapSize = this._io.readS2be();
            this.overTravel = this._io.readS2be();
            this.cdpX = this._io.readS4be();
            this.cdpY = this._io.readS4be();
            this.iline = this._io.readS4be();
            this.xline = this._io.readS4be();
            this.shotpoint = this._io.readS4be();
            this.scalerShotpoint = this._io.readS2be();
            this.traceUnit = this._io.readS2be();
            this.transductionMantissa = this._io.readS4be();
            this.transductionExp = this._io.readS2be();
            this.transductionUnit = this._io.readS2be();
            this.deviceId = this._io.readS2be();
            this.scalerTime = this._io.readS2be();
            this.sourceType = this._io.readS2be();
            this.sourceDirection1 = this._io.readS2be();
            this.sourceDirection2 = this._io.readS2be();
            this.sourceDirection3 = this._io.readS2be();
            this.sourceMeasurementMantissa = this._io.readS4be();
            this.sourceMeasurementExp = this._io.readS2be();
            this.sourceMeasurementUnit = this._io.readS2be();
            this.unassigned = this._io.readBytes(8);
        }
        private int traceSeqNumLine;
        private int traceSeqNumReel;
        private int ffid;
        private int traceno;
        private int source;
        private int cdp;
        private int tracenoEns1;
        private short idCode;
        private short stckcntV;
        private short stckcntH;
        private short dataUse;
        private int offset;
        private int recElev;
        private int souElev;
        private int depth;
        private int recDatum;
        private int souDatum;
        private int souH2o;
        private int recH2o;
        private short scalerElevs;
        private short scalerCords;
        private int souX;
        private int souY;
        private int recX;
        private int recY;
        private short units;
        private short weatheringVelocity;
        private short subweatheringVelocity;
        private short upholeTimeSou;
        private short upholeTimeRec;
        private short souStat;
        private short recStat;
        private short totalStat;
        private short lagA;
        private short lagB;
        private short delay;
        private short muteTimeStart;
        private short muteTimeEnd;
        private short nSamplesCurrent;
        private short dtCurrent;
        private short gainType;
        private short instrumentGain;
        private short earlyGain;
        private short correlated;
        private short sweepStart;
        private short sweepEnd;
        private short sweepLength;
        private short sweepType;
        private short sweepTaperStart;
        private short sweepTaperEnd;
        private short taperType;
        private short aliasFreq;
        private short aliasSlope;
        private short notchFreq;
        private short notchSlope;
        private short lowcutFreq;
        private short highcutFreq;
        private short lowcutSlope;
        private short highcutSlope;
        private short year;
        private short day;
        private short hour;
        private short minute;
        private short second;
        private short timeBasisCode;
        private short traceWeightFactor;
        private short groupnoRoll;
        private short groupnoFirstField;
        private short groupnoLastField;
        private short gapSize;
        private short overTravel;
        private int cdpX;
        private int cdpY;
        private int iline;
        private int xline;
        private int shotpoint;
        private short scalerShotpoint;
        private short traceUnit;
        private int transductionMantissa;
        private short transductionExp;
        private short transductionUnit;
        private short deviceId;
        private short scalerTime;
        private short sourceType;
        private short sourceDirection1;
        private short sourceDirection2;
        private short sourceDirection3;
        private int sourceMeasurementMantissa;
        private short sourceMeasurementExp;
        private short sourceMeasurementUnit;
        private byte[] unassigned;
        private Segy _root;
        private Segy.Trace _parent;
        public int traceSeqNumLine() { return traceSeqNumLine; }
        public int traceSeqNumReel() { return traceSeqNumReel; }
        public int ffid() { return ffid; }
        public int traceno() { return traceno; }
        public int source() { return source; }
        public int cdp() { return cdp; }
        public int tracenoEns1() { return tracenoEns1; }
        public short idCode() { return idCode; }
        public short stckcntV() { return stckcntV; }
        public short stckcntH() { return stckcntH; }
        public short dataUse() { return dataUse; }
        public int offset() { return offset; }
        public int recElev() { return recElev; }
        public int souElev() { return souElev; }
        public int depth() { return depth; }
        public int recDatum() { return recDatum; }
        public int souDatum() { return souDatum; }
        public int souH2o() { return souH2o; }
        public int recH2o() { return recH2o; }
        public short scalerElevs() { return scalerElevs; }
        public short scalerCords() { return scalerCords; }
        public int souX() { return souX; }
        public int souY() { return souY; }
        public int recX() { return recX; }
        public int recY() { return recY; }
        public short units() { return units; }
        public short weatheringVelocity() { return weatheringVelocity; }
        public short subweatheringVelocity() { return subweatheringVelocity; }
        public short upholeTimeSou() { return upholeTimeSou; }
        public short upholeTimeRec() { return upholeTimeRec; }
        public short souStat() { return souStat; }
        public short recStat() { return recStat; }
        public short totalStat() { return totalStat; }
        public short lagA() { return lagA; }
        public short lagB() { return lagB; }
        public short delay() { return delay; }
        public short muteTimeStart() { return muteTimeStart; }
        public short muteTimeEnd() { return muteTimeEnd; }
        public short nSamplesCurrent() { return nSamplesCurrent; }
        public short dtCurrent() { return dtCurrent; }
        public short gainType() { return gainType; }
        public short instrumentGain() { return instrumentGain; }
        public short earlyGain() { return earlyGain; }
        public short correlated() { return correlated; }
        public short sweepStart() { return sweepStart; }
        public short sweepEnd() { return sweepEnd; }
        public short sweepLength() { return sweepLength; }
        public short sweepType() { return sweepType; }
        public short sweepTaperStart() { return sweepTaperStart; }
        public short sweepTaperEnd() { return sweepTaperEnd; }
        public short taperType() { return taperType; }
        public short aliasFreq() { return aliasFreq; }
        public short aliasSlope() { return aliasSlope; }
        public short notchFreq() { return notchFreq; }
        public short notchSlope() { return notchSlope; }
        public short lowcutFreq() { return lowcutFreq; }
        public short highcutFreq() { return highcutFreq; }
        public short lowcutSlope() { return lowcutSlope; }
        public short highcutSlope() { return highcutSlope; }
        public short year() { return year; }
        public short day() { return day; }
        public short hour() { return hour; }
        public short minute() { return minute; }
        public short second() { return second; }
        public short timeBasisCode() { return timeBasisCode; }
        public short traceWeightFactor() { return traceWeightFactor; }
        public short groupnoRoll() { return groupnoRoll; }
        public short groupnoFirstField() { return groupnoFirstField; }
        public short groupnoLastField() { return groupnoLastField; }
        public short gapSize() { return gapSize; }
        public short overTravel() { return overTravel; }
        public int cdpX() { return cdpX; }
        public int cdpY() { return cdpY; }
        public int iline() { return iline; }
        public int xline() { return xline; }
        public int shotpoint() { return shotpoint; }
        public short scalerShotpoint() { return scalerShotpoint; }
        public short traceUnit() { return traceUnit; }
        public int transductionMantissa() { return transductionMantissa; }
        public short transductionExp() { return transductionExp; }
        public short transductionUnit() { return transductionUnit; }
        public short deviceId() { return deviceId; }
        public short scalerTime() { return scalerTime; }
        public short sourceType() { return sourceType; }
        public short sourceDirection1() { return sourceDirection1; }
        public short sourceDirection2() { return sourceDirection2; }
        public short sourceDirection3() { return sourceDirection3; }
        public int sourceMeasurementMantissa() { return sourceMeasurementMantissa; }
        public short sourceMeasurementExp() { return sourceMeasurementExp; }
        public short sourceMeasurementUnit() { return sourceMeasurementUnit; }
        public byte[] unassigned() { return unassigned; }
        public Segy _root() { return _root; }
        public Segy.Trace _parent() { return _parent; }
    }
    private TextHeader txt;
    private BinaryHeader binary;
    private ArrayList<Trace> traces;
    private Segy _root;
    private KaitaiStruct _parent;
    public TextHeader txt() { return txt; }
    public BinaryHeader binary() { return binary; }
    public ArrayList<Trace> traces() { return traces; }
    public Segy _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}